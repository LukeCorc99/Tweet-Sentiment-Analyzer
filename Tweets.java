//package ie.atu.sw;

// Import necessary classes

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.Arrays;
import java.util.concurrent.ConcurrentSkipListMap;

public class Tweets {
    // Declare a static variable to keep track of the line number
    private static int line = 0;

    // Declare a ConcurrentSkipListMap to store words and their corresponding scores
    private ConcurrentSkipListMap<String, String> tweetWords = new ConcurrentSkipListMap<>();

    // Method to process a lexicon file
    public void go(String tweet) throws Exception {
        
        // Create a new virtual thread executor
        try (var pool = Executors.newVirtualThreadPerTaskExecutor()) {
            // Read each line of the file and process it in a separate thread
            Files.lines(Paths.get(tweet)).forEach(text -> pool.execute(() -> process(text, ++line)));
        } catch (IOException e) {  
        } catch (Exception e) {}

    }

   // Method to process a line of text
   public void process(String text, int line) {
    Arrays.stream(text.split("\\s+"))
          .map(word -> word.trim().replaceAll("[^a-zA-Z]", "").toLowerCase())
          .forEach(w -> tweetWords.put(w, ""));
}

    public ConcurrentSkipListMap<String, String> getTweetWords() {
        return tweetWords;
    }
}