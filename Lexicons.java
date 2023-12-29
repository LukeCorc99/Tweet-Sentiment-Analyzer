//package ie.atu.sw;

// Import necessary classes

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ConcurrentSkipListMap;

public class Lexicons {
    // Declare a static variable to keep track of the line number
    private static int line = 0;

    // Declare a ConcurrentSkipListMap to store words and their corresponding scores
    private ConcurrentSkipListMap<String, Double> lexWords = new ConcurrentSkipListMap<>();

    // Method to process a lexicon file
    public void go(String lexicon) throws Exception {
        
        // Create a new virtual thread executor
        try (var pool = Executors.newVirtualThreadPerTaskExecutor()) {
            // Read each line of the file and process it in a separate thread
            Files.lines(Paths.get(lexicon)).forEach(text -> pool.execute(() -> process(text, ++line)));
        } catch (IOException e) {
            // Handle any IOExceptions that might be thrown when reading the file
            e.printStackTrace();
        } catch (Exception e) {
            // Handle any other exceptions that might be thrown when processing the text
            e.printStackTrace();
        }

    }

    // Method to process a line of text
    public void process(String text, double line) {
        // Split the line into a word and a score
        String[] parts = text.split(",");

        // If the line contains exactly two parts
        if (parts.length == 2) {
            // The first part is the word
            String word = parts[0];
            // The second part is the score
            Double score = Double.parseDouble(parts[1]);

            // Store the word and score in the ConcurrentSkipListMap
            lexWords.put(word, score);
        }
    }

	public ConcurrentSkipListMap<String, Double> getLexWords() {
		return lexWords;
	}
}