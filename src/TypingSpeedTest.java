/*
 * @Author: Arwin Lado
 * Date: 09/01/2025
 * CPT main 
 */

// Heavily inspired by most typing games such as monkeytype
// https://monkeytype.com/ 
// Importing the libraries needed for this typingspeedtest
import java.util.Arrays;
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

        /**
         * Creates a while loop if the user wants to play the game again or not
         * 
         * @param playAgain is the boolean to check if the user wants to play again
         * @return if the user says no to the games it will just stop.
         */
        while (playAgain) {
            // Prints out the welcome message here for the user 
            System.out.println(welcoming_message);
            
            // Moved the typing test here and the timer
            TypingSpeedTest test = new TypingSpeedTest();

            // Prints out the levels by picking 1, 2 or 3
            System.out.println("1. Easy Level ");
            System.out.println("2. Medium Level");
            System.out.println("3. Proficient level");
            System.out.println("4. Troll Level");
            System.out.println("Pick your difficulty");

            int picking = scanner.nextInt();
            // flushes the line
            scanner.nextLine();
            
            /**
             * These are the list of the levels that the user will choose from
             * Within the list of the levels are setences that the user will be typing
             * List<string> Stores collections of elements of data types being the string or the setences
             * Arrays.asList is a method that basically takes the array and converts it into a list
             * @param easyLevel is the list of the easy level
             * @param mediumLevel is the list of the medium level
             * @param proficientLevel is the list of the proficient level
             * 
             */
            // I got array.aslist from https://www.geeksforgeeks.org/arrays-aslist-method-in-java-with-examples/
            List<String> easyLevel = Arrays.asList("The quick brown fox jumps over the lazy dog.");
            List<String> mediumLevel = Arrays.asList("I am a student at Father Michael Goetz Secondary School.");
            List<String> proficientLevel = Arrays.asList("This computer science course is one of the best courses I have ever taken. I would recommend it to anyone who is interested in learning how to learn computer science and pursuing computer science.");
            List<String> trollLevel = Arrays.asList("Pineapple on pizza is the best thing created, it adds flavors to the pizza and while at the same time being the best.");

            // This is the list of the level selected by the user
            List<String> selectedLevel = null;

            /**
             * Switch statement to check which level the user will choose
             * @param picking is the input that the user will choose
             * @return the level that the user will be playing if not it will quite the game.
             */
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
                case 4:
                    selectedLevel = trollLevel;
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

            /**
             * A enhanced for loop that will display the words that the user will type
             * @return the words that the user typed
             */

            for (Expression expression : test.getExpressions()) {
                System.out.println(expression.getText());
            }

            /**
             * Creates a enchaned for loop that will display the words and the user will type the following using the linklist
             * Uses scanner to get the user input
             *   
             */ 
            for(Expression expression : test.getExpressions()) {
                System.out.println("Enter the following: " + expression.getText());
                test.timer.start();
                String userExpressString = scanner.nextLine();
                test.timer.stop();

                /**
                 * Creates a if statement to check if the user typed the correct words 
                 * 
                 * @param userExpressString is the words that the user typed
                 * @return if the user types it correct he will get correct if not they will get wrong answer
                 */
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
