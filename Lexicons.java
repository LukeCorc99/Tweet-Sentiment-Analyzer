//package ie.atu.sw;


// Import necessary classes
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ConcurrentSkipListMap;

public class Lexicons {
    // Declare a static variable to keep track of the line number
    private static int line = 0;
    
    // Declare a ConcurrentSkipListMap to store words and their corresponding scores
    private ConcurrentSkipListMap<String, String> words = new ConcurrentSkipListMap<>();
    
    // Method to process a lexicon file
    public void go(String lexicon) throws Exception {
        // Construct the path to the lexicon file
        String path = "./Lexicon/" + lexicon;
        
        // Create a new virtual thread executor
        try (var pool = Executors.newVirtualThreadPerTaskExecutor()){
            // Read each line of the file and process it in a separate thread
            Files.lines(Paths.get(path)).forEach(text -> pool.execute(() -> process(text, ++line)));
        }
        
        // Print the words and their scores
        out.println(words);
        // Print the total number of words
        out.println(words.size());
    }
    
    // Method to process a line of text
    public void process(String text, int line) {
        // Split the line into a word and a score
        String[] parts = text.split(",");
        
        // If the line contains exactly two parts
        if (parts.length == 2) {
            // The first part is the word
            String word = parts[0];
            // The second part is the score
            String score = parts[1];
            
            // Store the word and score in the ConcurrentSkipListMap
            words.put(word, score);
        }
    }
}