import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;

public class Sentiment {
    public void analyse(ConcurrentSkipListMap<String, Double> lexWords,
            ConcurrentSkipListMap<String, String> tweetWords) {
        System.out.println("Tweet successfully processed! Number of words is: " + tweetWords.size());
        System.out.println("Lexicon successfully processed! Number of words is: " + lexWords.size());
        int totalWords = 0;
        int positiveWords = 0;
        int negativeWords = 0;
        // Initialize positive and negative variables
        double positive = 0.0;
        double negative = 0.0;

        // Get the set of keys from both maps
        Set<String> lexWordsKeys = new HashSet<>(lexWords.keySet());
        Set<String> tweetWordsKeys = new HashSet<>(tweetWords.keySet());

        // Get the matching words
        lexWordsKeys.retainAll(tweetWordsKeys);

        // Create a list to store the values corresponding to the matching keys
        List<Double> matchingValues = new ArrayList<>();

        // Iterate over the set of matching keys
        for (String key : lexWordsKeys) {
            // If the key is present in lexWords, add the corresponding value to the list
            if (lexWords.containsKey(key)) {
                matchingValues.add(lexWords.get(key));
                totalWords++;
            }
        }

        // Print the list of matching values
        System.out.println("\n\nMatching words: " + lexWordsKeys);

        // Print the list of matching values
        System.out.println("\nAmount of matching values: " + totalWords);

        // Iterate over the list of matching values
        for (Double value : matchingValues) {
            // If the value is greater than 0, add it to positive
            if (value > 0) {
                positive += value;
                positiveWords++;
            }
            // If the value is less than 0, subtract it from negative
            else if (value < 0) {
                negative -= value;
                negativeWords++;
            }
        }

        // Print the positive and negative variables
        System.out.println("\n\nPositive: " + positive);
        System.out.println("Negative: " + negative);
        System.out.println("Score and Sum (SaS): " + (positive - negative));

        int scoreFromTotal = ((positiveWords - negativeWords) / totalWords);

        System.out.println("Score from Total (SfT): " + scoreFromTotal);

        if (scoreFromTotal == 0) {
            System.out.println("\nOverall sentiment is Neutral.\n");
        } else if (scoreFromTotal > 0) {
            System.out.println("\nOverall sentiment is Positive.\n");
        } else if (scoreFromTotal < 0) {
            System.out.println("\nOverall sentiment is Negative.\n");
        }
    }
}
