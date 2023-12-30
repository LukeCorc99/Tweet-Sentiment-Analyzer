import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;

public class Sentiment {
    public void analyse(ConcurrentSkipListMap<String, Double> lexWords, ConcurrentSkipListMap<String, String> tweetWords) {
        System.out.println("Tweet successfully processed! Number of words is: "+tweetWords.size());
        System.out.println("Lexicon successfully processed! Number of words is: "+lexWords.size());
        int i = 0;

        // Get the set of keys from both maps
        Set<String> lexWordsKeys = new HashSet<>(lexWords.keySet());
        Set<String> tweetWordsKeys = new HashSet<>(tweetWords.keySet());

        // Get the intersection of the two sets
        lexWordsKeys.retainAll(tweetWordsKeys);

        // Print the number of matching words
        System.out.println("Number of matching words: " + lexWordsKeys.size());
        // Print the number of matching words
        System.out.println("\n" + lexWordsKeys);
    // Create a list to store the values corresponding to the matching keys
        List<Double> matchingValues = new ArrayList<>();

        // Iterate over the set of matching keys
        for (String key : lexWordsKeys) {
            // If the key is present in lexWords, add the corresponding value to the list
            if (lexWords.containsKey(key)) {
                matchingValues.add(lexWords.get(key));
                i++;
            }
        }

        // Print the list of matching values
        System.out.println("Matching values: " + matchingValues);

        // Print the list of matching values
        System.out.println("Amount of matching values: " + i);
    }
    }

