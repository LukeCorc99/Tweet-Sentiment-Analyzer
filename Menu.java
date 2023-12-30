//package ie.atu.sw;


import java.util.Scanner;
import java.util.concurrent.ConcurrentSkipListMap;

public class Menu {
    public void displayMenu() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ConcurrentSkipListMap<String, String> tweetWordsCopy = new ConcurrentSkipListMap<>();
        ConcurrentSkipListMap<String, Double> lexWordsCopy = new ConcurrentSkipListMap<>();
        String option = "0";
       

        while (option.equals("0") || option.equals("1") || option.equals("2") || option.equals("3")) {
            System.out.println(ConsoleColour.WHITE);
            System.out.println("************************************************************");
            System.out.println("*     ATU - Dept. of Computer Science & Applied Physics    *");
            System.out.println("*             Virtual Threaded Sentiment Analyser          *");
            System.out.println("*                   by Luke Corcoran                       *");
            System.out.println("*                      G00410404                           *");
            System.out.println("************************************************************");
            System.out.println("(1) Configure Lexicons");
            System.out.println("(2) Specify a Text File");
            System.out.println("(3) Execute, Analyse and Report");

            System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
            System.out.println("Select Option 1-3, 0 to reload menu or press any other key to quit.");
            option = scanner.next();
            if (option.equals("1")) {
                System.out.println("Please choose a lexicon:");
                System.out.println("• ./Lexicons/afinn.txt");
                System.out.println("• ./Lexicons/bingliu.txt");
                System.out.println("• ./Lexicons/mpqa.txt");
                System.out.println("• ./Lexicons/textblob.txt");
                System.out.println("• ./Lexicons/vader.txt");
            
                Lexicons lexicons = new Lexicons();
                String lex = "";
                boolean validInput = false;
            
                while (!validInput) {
                    System.out.print("Enter path to your desired lexicon: ");
                    lex = scanner.next();
            
                    if (lex.equals("./Lexicons/afinn.txt") || lex.equals("./Lexicons/bingliu.txt") || lex.equals("./Lexicons/mpqa.txt") || lex.equals("./Lexicons/textblob.txt") || lex.equals("./Lexicons/vader.txt")) {
                        validInput = true;
                    } else {
                        System.out.println("Lexicon does not exist/path invalid! Please enter again.");
                    }
                }
            
                try {
                    lexicons.go(lex);
                    lexWordsCopy.putAll(lexicons.getLexWords());
                     // Print the contents of lexWordsCopy
                    System.out.println("Lexicon successfully processed! Number of words is: "+lexWordsCopy.size());
                } catch (Exception e) {
                    System.out.println("Error occured while processing the lexicon: " + e.getMessage());
                }
            
            } else if (option.equals("2")) {

                System.out.print("Enter the path to the tweet file (remember to add .txt at the end): ");
                String tweetFile = scanner.next();

                Tweets tweets = new Tweets();

                try {
                    tweets.go(tweetFile);
                    tweetWordsCopy.putAll(tweets.getTweetWords());
                     while (tweetWordsCopy.size() == 0) {
                         System.out.println("Tweet does not exist/path invalid! Please enter again.");
                         System.out.print("Enter the path to the tweet file (remember to add .txt at the end): ");
                         tweetFile = scanner.next();
                         tweets.go(tweetFile);
                         tweetWordsCopy.putAll(tweets.getTweetWords());
                     }
                     // Print the contents of lexWordsCopy
                    System.out.println("Tweet successfully processed! Number of words is: "+tweetWordsCopy.size());
                } catch (Exception e) {
                    System.out.println("Tweet does not exist/path invalid!");
                }

                
            } if (option.equals("3")) {
                System.out.println("Sentiment analysis is now running:\n");
                Sentiment sentiment = new Sentiment();
                sentiment.analyse(lexWordsCopy, tweetWordsCopy);
            } 

            System.out.print(ConsoleColour.YELLOW);
            int size = 100;
            for (int i = 0; i < size; i++) {
                printProgress(i + 1, size);
                Thread.sleep(10);
            }
        }
        System.out.println("\n\nGoodbye\n\n");
    }

    

	public static void printProgress(int index, int total) {
		if (index > total) return;	
        int size = 50; 				
	    char done = '█';			
	    char todo = '░';			
	    
	    //Compute basic metrics for the meter
        int complete = (100 * index) / total;
        int completeLen = size * complete / 100;

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
        	sb.append((i < completeLen) ? done : todo);
        }
        System.out.print("\r" + sb + "] " + complete + "%");
        
        //Once the meter reaches its max, move to a new line.
        if (done == total) System.out.println("\n");
    }

}



