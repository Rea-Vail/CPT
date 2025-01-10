/*
 * @Author: Arwin Lado
 * Date: 09/01/2025
 * CPT main 
 */

// Heavily inspired by most typing games such as monkeytype
// https://monkeytype.com/ 
// Importing the libraries needed for this typingspeedtest
// importing list and linkedlist
import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;


// Main class Typingtype
public class TypingSpeedTest {
    // Instance private variable ExpressManager
    private ExpressionManager expressionManager;


    // Creates a overloaded constructor for TypingSpeedTest
    // @this.expressManaager as a instance variable
    public TypingSpeedTest() {
        this.expressionManager = new ExpressionManager();
    }

    // Adds a public void for expression as a parameter that will make the user type the words
    // Expression will be added to the expression manager 
    public void addExpression(String expression){
        expressionManager.addExpression(new Expression(expression));
    }

    // will fix this later
    // This is were the linkedlist well be added
    // Returning the linkedlist of the expressions of what will the user will say
    public List<Expression> getExpressions() {
        return expressionManager.getExpressions();
    }

    // Main method of running TypingSpeedtest
    // Added a scanner for the user to type the words out!
    // will add the test later woo
    /**
     * This will be the main method of the TypingSpeedTest we're all the expressions of words will be 
     * going to be added and goes towards the linkedlist and for loop
     * @param test represents the test TypingSpeedTest
     * 
     */
    public static void main(String[] args) {
        // Display a welcome message to the user in the terminal
        System.out.println("(~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~)");
        System.out.println("(~~~~~~~ Typing Speed Test ~~~~~~)");
        System.out.println("(~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~)");
        System.out.println("(Welcome to the Typing Speed Test!)");
        System.out.println("(~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~)");
        
        // goes through if the user clicks enter
        Scanner scanner = new Scanner(System.in);
        TypingSpeedTest test = new TypingSpeedTest();
        test.addExpression("Yo yo yo what's up!");
        test.addExpression("I LOVE CANADA");
        System.out.println("Enter your words");
        String userExpressString = scanner.nextLine();
            
        // adds for loop
        for (Expression expression : test.getExpressions()) {
            System.out.println(expression.getText());
        }
        // closes the scanner
        scanner.close();
    }
}

/**
 * This class is to represents the expression of words
 * @param Expression represents the expression of words for TypingSpeedTest
 * It works as a way for words to be placed in here and making the user type the words here
 */
class Expression {
    // adds a instance string
    private String text;

    // Creating a constructor for string text
    public Expression(String text) {
        this.text = text;
    }

    //  creating a public string that returns a string being the text
    public String getText() {
        return text;
    }
}

/**
 * Creates a class for expressionManager
 * @param ExpressionManager represents linkedlist for the expressions and it will manage the expressions of words
 * It will be stored as a linkedlist in this following class!
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
 * Creates a class for timer that extends the expression used for timing the user typing the words out!
 * @param Timer represents the timer for the time how long can the user type the words
 */
class Timer extends Expression {
    // Implemented a long data type that basically represents the int values of the time
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

    // Elasped time is a way for calculating and returning the time has passed between the start and finish
    // for example if the time is
    public long getElaspedTime() {
        return endTime - startTime;
    }

    
}

// Ill add more stuff later 8:31 pm real
// will fix all the errors later!