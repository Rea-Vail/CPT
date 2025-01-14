/*
 * @Author: Arwin Lado
 * Date: 09/01/2025
 * CPT main 
 */

// Heavily inspired by most typing games such as monkeytype
// https://monkeytype.com/ 
// Importing the libraries needed for this typingspeedtest
// importing list, linkedlist and arrays
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Main class TypingSpeedTest
public class TypingSpeedTest {
    // add a private static final string for the welcome message moved here
    private static final String welcoming_message = "(~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~)\n"
                                                + "(~~~~~~~ Typing Speed Test ~~~~~~)\n"
                                                + "(~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~)\n"
                                                + "(Welcome to the Typing Speed Test!)\n"
                                                + "(~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~)";
    // Instance private variable ExpressionManager
    private ExpressionManager expressionManager;

    // Creates a constructor for TypingSpeedTest
    public TypingSpeedTest() {
        this.expressionManager = new ExpressionManager();
    }

    // Adds a public void for expression as a parameter that will make the user type
    // the words
    // Expression will be added to the expression manager
    public void addExpression(String expression) {
        expressionManager.addExpression(new Expression(expression));
    }

    // Returning the linked list of the expressions of what the user will say
    public List<Expression> getExpressions() {
        return expressionManager.getExpressions();
    }

    // Main method of running TypingSpeedTest
    /**
     * Main method for TypingSpeedTest that will run the test and display the words.
     * @param args represents the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            // Prints out the welcome message here for the user 
            System.out.println(welcoming_message);
            
            // Moved the typing test here and the timer
            TypingSpeedTest test = new TypingSpeedTest();
            Timer timer = new Timer(); // Removed the unnecessary parameter

            // Adding difficulty that the user can choose
            // by picking 1, 2 or 3
            System.out.println("1. Easy Level ");
            System.out.println("2. Medium Level");
            System.out.println("3. Proficient level");
            System.out.println("Pick your difficulty");

            // Allows the user to pick which difficulty they want.
            int picking = scanner.nextInt();
            // flushes the line
            scanner.nextLine();
            
            // List of words for each level that they will type
            List<String> easyLevel = Arrays.asList("The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog");
            List<String> mediumLevel = Arrays.asList("I", "am", "a", "student", "at", "Father", "Michael", "Goetz", "Secondary", "School");
            List<String> proficientLevel = Arrays.asList("This", "computer", "science", "course", "is", "one", "of", "the", "best", "courses", "I", "have", "ever", "taken", "and", "I", "would recommend", "it", "to", "anyone", "who", "is", "interested", "in", "learning", "how", "to", "do", "computer science");

            // This is the list of the level selected by the user
            List<String> selectedLevel = null;

            // Implemented a switch statement for the user to pick their level
            switch(picking) {
                case 1:
                    selectedLevel = easyLevel;
                    break;
                case 2:
                    selectedLevel = mediumLevel;
                    break;
                case 3:
                    selectedLevel = proficientLevel;
                    break;
                default:
                    System.out.println("No level was chosen. Quitting the game....");
                    scanner.close();
                    return;
            }

            // This section displays the words that the user selected level will be
            System.out.println("Enter the following");
            for (String word : selectedLevel) {
                System.out.print(word + " ");
            }
            System.out.println();

            // welcome message for the user
            System.out.println("Enter your words");
            timer.start();
            String userExpressString = scanner.nextLine();
            test.addExpression(userExpressString);
            timer.stop();

            // Calculation for words per minute
            // this calculation is to count the number of words of what the user will input
            // and stores those numbers in this variable
            int wordCount = userExpressString.split("\\s+").length;
            double wpm = timer.calculateWPM(wordCount);

            // adds for loop to go through the expressions and prints out the WPM word per minute
            for (Expression expression : test.getExpressions()) {
                System.out.println(expression.getText());
            }
            // prints out the WPM results
            System.out.println("Words per minute: " + wpm);

            // Implementing a play again feature if the user says yes it will play again
            System.out.println("Congrats for playing! Do you want to play again? (yes/no)");
            // my source is here https://docs.oracle.com/en/java/javacard/3.1/guide/response-string-description.html
            String response = scanner.nextLine(); // String respoinse are ways resoibse and enter the words
            // a simple if statement if the user says no the games will stop
            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        // closes the scanner
        scanner.close();
    }
}

/**
 * This class is to represents the expression of words by using string text and ToString methods
 * @param Expression represents the expression of words for TypingSpeedTest
 * It works as a way for words to be placed in here and making the user type the words here.
 * @return text returns the text of the expression/words
 */
class Expression {
    // adds a instance string
    private String text;

    // Creating a constructor for string text
    public Expression(String text) {
        this.text = text;
    }

    // creating a public string that returns a string being the text
    public String getText() {
        return text;
    }

    // This toString returns the text of the expression
    @Override
    public String toString() {
        return "Expression{" + "text='" + text + '\'' + '}';
    }
}

/**
 * Creates a class for expressionManager
 * 
 * @param ExpressionManager represents linkedlist for the expressions and it will manage the expressions of words
 * It will be stored as a linkedlist in this following class!
 * @return expressions returns expressions as it will be stored within the linkedlist of expressions 
 */

// little issue was the name fixed changed!
class ExpressionManager {
    // instance variable for expressions as linkedlist
    private List<Expression> expressions;

    // constructor for the expression manager
    public ExpressionManager() {
        this.expressions = new LinkedList<>();
    }

    // adds a public void for expression
    public void addExpression(Expression expression) {
        expressions.add(expression);
    }

    // adds a public list for the expressions
    // It then returns the expressions
    public List<Expression> getExpressions() {
        return expressions;
    }
}

/**
 * Creates a class for Timer
 * This class is used for timing the user typing the words out!
 * @param timer represents the timer for the user typing the words
 * @return startime returns the start time while endtime returns the end time after the test is finish
 * After it over it will return the WPM and time remaining of the test!
 */
class Timer  {
    // Implemented a long data type that basically represents the int values of the
    // time
    // I got this data type from this
    // https://www.w3schools.com/java/java_data_types.asp
    private long startTime;
    private long endTime;

    // This is both the start and stop method for the timer itself
    // the data type I got 1currentTimeMillis is from this
    // https://www.tutorialspoint.com/java/lang/system_currenttimemillis.htm
    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    // Elapsed time is a way for calculating and returning the time has passed
    // between the start and finish
    // for example if the time is 5 seconds left it will return 5000 milliseconds
    public long getElapsedTime() {
        return endTime - startTime;
    }

    /**
    * This method calculates the words per minute of the user and time remaining
    * @param elapsedTimeMillis represents how many seconds the user has typed the words
    * @param wordCount How many words the user has typed and counts it
    */
    public double calculateWPM(int wordCount) {
        long elapsedTimeMillis = getElapsedTime();
        double elapsedTimeMinutes = elapsedTimeMillis / 60000.0;
        return wordCount / elapsedTimeMinutes;
    }
}

// going to implement int checker.