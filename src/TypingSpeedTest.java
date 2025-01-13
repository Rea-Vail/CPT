/*
 * @Author: Arwin Lado
 * Date: 09/01/2025
 * CPT main 
 */

// Heavily inspired by most typing games such as monkeytype
// https://monkeytype.com/ 
// Importing the libraries needed for this typingspeedtest
// importing list and linkedlist
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Main class Typingtype
public class TypingSpeedTest {
    // Instance private variable ExpressManager
    private ExpressionManager expressionManager;

    // Creates a overloaded constructor for TypingSpeedTest
    // @this.expressManaager as a instance variable
    public TypingSpeedTest() {
        this.expressionManager = new ExpressionManager();
    }

    // Adds a public void for expression as a parameter that will make the user type
    // the words
    // Expression will be added to the expression manager
    public void addExpression(String expression) {
        expressionManager.addExpression(new Expression(expression));
    }

    // will fix this later
    // This is were the linkedlist well be added
    // Returning the linkedlist of the expressions of what will the user will say
    public List<Expression> getExpressions() {
        return expressionManager.getExpressions();
    }

    // Main method of running TypingSpeedtest
    /**
     * Main method for TypingSpeedTest that will run the test and display the words.
     * @param timer represents the timer for the typing speed test
     * @param test represents the test TypingSpeedTest
     * @param wordCount word counts the user words in the test
     * @param wpm represents words per minute
     * 
     */
    public static void main(String[] args) {
        // Display a welcome message to the user in the terminal
        System.out.println("(~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~)");
        System.out.println("(~~~~~~~ Typing Speed Test ~~~~~~)");
        System.out.println("(~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~)");
        System.out.println("(Welcome to the Typing Speed Test!)");
        System.out.println("(~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~)");
        
        // Adding difficulty that the user can choose
        // by picking 1, 2 or 3
        System.out.println("1. Easy Level ");
        System.out.println("2. Medium Level");
        System.out.println("3. Proficient level");
        System.out.println("Pick your difficulty");

        // goes through if the user clicks enter
        Scanner scanner = new Scanner(System.in);
        // Allows the user to pick which difficulty they want.
        int picking = scanner.nextInt();
        // flushes the line
        scanner.nextLine();

        
        TypingSpeedTest test = new TypingSpeedTest();
        // prints out the timer
        Timer timer = new Timer("Typing test timer test");

        // welcome message for the user
        System.out.println("Enter your words");
        timer.start();
        String userExpressString = scanner.nextLine();
        test.addExpression(userExpressString);
        timer.stop();

        // prints out the time that the user will take to type the words.
        test.addExpression(userExpressString);

        // Calculation for words per minute
        // this calculation is to count the number of words of what the user will input
        // and stores those numbers in this variable
        int wordCount = userExpressString.split("\\s+").length;
        double wpm = timer.calculateWPM(wordCount);

        // adds for loop to go through the expressions and prints out the WPM word per
        // minute
        for (Expression expression : test.getExpressions()) {
            System.out.println(expression.getText());
        }
        // prints out the WPM results
        System.out.println("Words per minute:" + wpm);
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

    // Added a tostring method for the text/Expression class for better
    // understanding
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

    // constructor for the expression
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
 * Creates a class for timer that extends the expression used for timing the
 * user typing the words out!
 * @param Timer represents the timer for the time how long can the user type the words
 * @param startTime represents the start time of the timer
 * @param endTime reppresents the end time of the timer 
 * @return This will return that the time has passed after the user has typed the words.
 */
class Timer extends Expression {
    // Implemented a long data type that basically represents the int values of the
    // time
    // I got this data type from this
    // https://www.w3schools.com/java/java_data_types.asp
    private long startTime;
    private long endTime;

    public Timer(String text) {
        super(text);
    }

    // This is both the start and stop method for the timer itself
    // the data type I got 1currentTimeMillis is from this
    // https://www.tutorialspoint.com/java/lang/system_currenttimemillis.htm
    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    // Elasped time is a way for calculating and returning the time has passed
    // between the start and finish
    // for example if the time is 5 seconds left it will return 5000 milliseconds
    public long getElaspedTime() {
        return endTime - startTime;
    }

    /**
    * This method calculates the words per minute of the user and time remaining
    * @param elaspedTimeMillis represents how many seconds the user has typed the words
    * @param wordcount How many words the user has typed and counts it
    * @return This method will return the words per minute of the user by dividing the words counted and total minutes
    */
    public double calculateWPM(int wordCount) {
        long elapsedTimeMillis = getElaspedTime();

        // this is the formula for calculating words per minute
        // example 200 words / 2 minutes = 100 words per minute
        double elapsedTimeMinutes = elapsedTimeMillis / 60000.0; // converted milliseconds to minutes
        return wordCount / elapsedTimeMinutes;
    }
}
