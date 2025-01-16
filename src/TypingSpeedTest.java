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

/**
 * Main class TypingSpeedTest
 * 
 * This class manages the typing speed test, including adding expressions and retrieving them.
 */
public class TypingSpeedTest {
    // add a private static final string for the welcome message moved here
    private static final String welcoming_message = "(~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~)\n"
                                                + "(~~~~~~~ Typing Speed Test ~~~~~~)\n"
                                                + "(~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~)\n"
                                                + "(Welcome to the Typing Speed Test!)\n"
                                                + "(~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~)";
    // Instance private variable ExpressionManager
    private ExpressionManager expressionManager;
    // Instance private variable Timer
    private Timer timer;

    /**
     * Constructor for TypingSpeedTest.
     * Initializes the ExpressionManager and Timer.
     */
    public TypingSpeedTest() {
        this.expressionManager = new ExpressionManager();
        this.timer = new Timer();
    }

    /**
     * Adds an expression to the expression manager.
     * 
     * @param expression the expression to be added.
     */
    public void addExpression(String expression) {
        expressionManager.addExpression(new Expression(expression));
    }

    /**
     * Retrieves the list of expressions.
     * 
     * @return the list of expressions.
     */
    public List<Expression> getExpressions() {
        return expressionManager.getExpressions();
    }

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
            List<String> easyLevel = Arrays.asList("The quick brown fox jumps over the lazy dog.");
            List<String> mediumLevel = Arrays.asList("I am a student at Father Michael Goetz Secondary School.");
            List<String> proficientLevel = Arrays.asList("This computer science course is one of the best courses I have ever taken and I would recommend it to anyone who is interested in learning how to do computer science.");

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
                    return;
            }

            // Add expressions to the test based on the level selected
            for(String word : selectedLevel) {
                test.addExpression(word);
            }

            // Debugging: Print all expressions added to the test
            System.out.println("Expressions added to the test:");
            for (Expression expression : test.getExpressions()) {
                System.out.println(expression.getText());
            }

            // Goes through a for loop that will display the words and the user will type the following
            for(Expression expression : test.getExpressions()) {
                System.out.println("Enter the following: " + expression.getText());
                test.timer.start();
                String userExpressString = scanner.nextLine();
                test.timer.stop();

                // This simple if else statement checks if the user has typed the same input as displayed in the following
                if (userExpressString.equals(expression.getText())) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Wrong answer at least you tried! The correct expression was: " + expression.getText());
                    System.out.println("Ending the test...good try..again..");
                    break;
                }
                // https://www.w3schools.com/java/ref_string_split.asp
                // Split basically splits the words by spaces and turns into an array of substrings.
                int wordCount = expression.getText().split("\\s+").length;
                double wpm = test.timer.calculateWPM(wordCount);
                System.out.println("Your typing speed is: " + wpm + " words per minute.");
            }

            // Asking the user if they want to play again.
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
 * This class represents an expression of words using a string text.
 * It is used in the TypingSpeedTest to store and manage the words that the user will type.
 */
class Expression {
    // Instance variable for the text of the expression
    private String text;

    /**
     * Constructor for the Expression class.
     * 
     * @param text the text of the expression.
     */
    public Expression(String text) {
        this.text = text;
    }

    /**
     * Retrieves the text of the expression.
     * 
     * @return the text of the expression.
     */
    public String getText() {
        return text;
    }

    /**
     * Returns a string representation of the expression.
     * 
     * @return a string representation of the expression.
     */
    @Override
    public String toString() {
        return "Expression{" + "text='" + text + '\'' + '}';
    }
}

/**
 * Creates a class for ExpressionManager
 * 
 * This class manages a list of expressions and provides methods to add and retrieve expressions.
 */
class ExpressionManager {
    // instance variable for expressions as linkedlist
    private List<Expression> expressions;

    /**
     * Constructor for the ExpressionManager.
     * Initializes the expressions list as a LinkedList.
     */
    public ExpressionManager() {
        this.expressions = new LinkedList<>();
    }

    /**
     * Adds an expression to the expressions list.
     * 
     * @param expression the expression to be added.
     */
    public void addExpression(Expression expression) {
        expressions.add(expression);
    }

    /**
     * Retrieves the list of expressions.
     * 
     * @return the list of expressions.
     */
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

    /**
     * Starts the timer by recording the current system time in milliseconds.
     */
    public void start() {
        startTime = System.currentTimeMillis();
    }

    /**
     * Stops the timer by recording the current system time in milliseconds.
     */
    public void stop() {
        endTime = System.currentTimeMillis();
    }

    /**
     * Calculates the elapsed time between the start and stop of the timer.
     * 
     * @return the elapsed time in milliseconds.
     */
    public long getElapsedTime() {
        return endTime - startTime;
    }

    /**
     * Calculates the words per minute (WPM) based on the number of words typed and the elapsed time.
     * 
     * @param wordCount the number of words typed by the user.
     * @return the words per minute (WPM) calculated.
     */
    public double calculateWPM(int wordCount) {
        long elapsedTimeMillis = getElapsedTime();
        double elapsedTimeMinutes = elapsedTimeMillis / 60000.0;
        return wordCount / elapsedTimeMinutes;
    }
}