import java.util.concurrent.ConcurrentSkipListMap;

public class Sentiment {
    public void analyse(ConcurrentSkipListMap<String, Double> lexWords, ConcurrentSkipListMap<String, String> tweetWords) {
        System.out.println("Tweet successfully processed! Number of words is: "+tweetWords.size());
        System.out.println("Lexicon successfully processed! Number of words is: "+lexWords.size());
    }
}
