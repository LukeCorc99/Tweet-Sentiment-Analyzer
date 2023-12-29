//package ie.atu.sw;

import java.util.Scanner;

public class Menu {
    public void displayMenu() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
       

        while (true) {
            System.out.println(ConsoleColour.WHITE);
            System.out.println("************************************************************");
            System.out.println("*     ATU - Dept. of Computer Science & Applied Physics    *");
            System.out.println("*             Virtual Threaded Sentiment Analyser          *");
            System.out.println("*                      by Luke Corcoran                    *");
            System.out.println("*                      G00410404                           *");
            System.out.println("************************************************************");
            System.out.println("(1) Configure Lexicons");
            System.out.println("(2) Specify a Text File");
            System.out.println("(3) Execute, Analyse and Report");

            System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
            System.out.println("Select Option 1-3 or press any other key to quit.");
            String option = scanner.next();
            if (option.equals("1")) {
                // Handle option 1
            } else if (option.equals("2")) {
                // Handle option 2
            } else if (option.equals("3")) {
                // Handle option 3
            } else {
                System.out.println("Goodbye!");
                System.exit(0);
            }

            System.out.print(ConsoleColour.YELLOW);
            int size = 100;
            for (int i = 0; i < size; i++) {
                printProgress(i + 1, size);
                Thread.sleep(10);
            }
            
        }
    }


    // Assuming printProgress method is defined somewhere in your class or imported from elsewhere
    	/*
	 *  Terminal Progress Meter
	 *  -----------------------
	 *  You might find the progress meter below useful. The progress effect 
	 *  works best if you call this method from inside a loop and do not call
	 *  System.out.println(....) until the progress meter is finished.
	 *  
	 *  Please note the following carefully:
	 *  
	 *  1) The progress meter will NOT work in the Eclipse console, but will
	 *     work on Windows (DOS), Mac and Linux terminals.
	 *     
	 *  2) The meter works by using the line feed character "\r" to return to
	 *     the start of the current line and writes out the updated progress
	 *     over the existing information. If you output any text between 
	 *     calling this method, i.e. System.out.println(....), then the next
	 *     call to the progress meter will output the status to the next line.
	 *      
	 *  3) If the variable size is greater than the terminal width, a new line
	 *     escape character "\n" will be automatically added and the meter won't
	 *     work properly.  
	 *  
	 * 
	 */
	public static void printProgress(int index, int total) {
		if (index > total) return;	//Out of range
        int size = 50; 				//Must be less than console width
	    char done = '█';			//Change to whatever you like.
	    char todo = '░';			//Change to whatever you like.
	    
	    //Compute basic metrics for the meter
        int complete = (100 * index) / total;
        int completeLen = size * complete / 100;
        
        /*
         * A StringBuilder should be used for string concatenation inside a 
         * loop. However, as the number of loop iterations is small, using
         * the "+" operator may be more efficient as the instructions can
         * be optimized by the compiler. Either way, the performance overhead
         * will be marginal.  
         */
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
        	sb.append((i < completeLen) ? done : todo);
        }
        
        /*
         * The line feed escape character "\r" returns the cursor to the 
         * start of the current line. Calling print(...) overwrites the
         * existing line and creates the illusion of an animation.
         */
        System.out.print("\r" + sb + "] " + complete + "%");
        
        //Once the meter reaches its max, move to a new line.
        if (done == total) System.out.println("\n");
    }

}



