# Sentiment Analyzer by Luke Corcoran

**Overview**

Sentiment Analyzer is a Java-based project designed to analyze the sentiment of text, particularly tweets, using a lexicon-based approach. By matching words in a given text with sentiment scores from a predefined lexicon, the project evaluates whether the overall sentiment of the text is Positive, Negative, or Neutral. This tool is ideal for basic sentiment analysis tasks, especially for processing social media content like tweets.

**Features**

1. Word Matching: Matches words from the text with a predefined sentiment lexicon.

2. Sentiment Scoring: Calculates overall sentiment scores based on matching words.

3. Sentiment Classification: Classifies text as Positive, Negative, or Neutral based on sentiment scores.

4. Detailed Debugging: Outputs matched words, their sentiment values, and the final score.

**Installation**

1. Clone the Repository:
```
git clone https://github.com/yourusername/Sentiment-Analyzer.git
```

2. Open the Project:
Open the project in your preferred IDE (e.g., IntelliJ IDEA or Eclipse).

3. Compile and Run:
Ensure you have Java installed (version 8 or higher). Compile and run the Sentiment.java file.
```
javac Sentiment.java
java Sentiment
```

**Usage**

1. Input Data:

Prepare a lexicon with words and their corresponding sentiment scores in a ConcurrentSkipListMap<String, Double>.

Provide tweet words in a ConcurrentSkipListMap<String, String>.

2. Analyze Sentiment:

Call the analyse method with the lexicon and tweet word maps.

3. Output:

The program outputs:

Number of matching words.

Total positive and negative scores.

Overall sentiment classification (Positive, Negative, Neutral).

**Example:**

*Lexicon:*

ConcurrentSkipListMap<String, Double> lexWords = new ConcurrentSkipListMap<>();
lexWords.put("happy", 1.5);
lexWords.put("sad", -2.0);
lexWords.put("great", 1.0);

*Tweet Words:*

ConcurrentSkipListMap<String, String> tweetWords = new ConcurrentSkipListMap<>();
tweetWords.put("happy", "used");
tweetWords.put("great", "used");
tweetWords.put("bad", "used");

*Output:*

Tweet successfully processed! Number of words is: 3
Lexicon successfully processed! Number of words is: 3

Matching words: [happy, great]
Amount of matching values: 2

Positive: 2.5
Negative: 0.0
Score and Sum (SaS): 2.5
Score from Total (SfT): 1

Overall sentiment is Positive.

**Requirements:**

Java 8 or higher

IDE or terminal for running Java programs

