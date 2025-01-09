/*
 * @Author: Arwin Lado
 * Date: 09/01/2025
 * CPT main 
 */

// Importing the libraries needed for this typingspeedtest
// 
import java.util.LinkedList;
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

    // Adds a public void for expression as a parameter that will make the user type the words
    // Expression will be added to the expression manager 
    public void addExpression(String expression){
        expressionManager.addExpression(new Expression(expression));
    }

    // will fix this later
    // This is were the linkedlist will be added
    // Returning the linkedlist of the expressions of what will the user will say
    public list<Expression> getExpressions() {
        return expressionManager.getExpressions();
    }

    // Main method of running TypingSpeedtest
    // will add the test later woo
    public static void main(String[] args) {
        
    }
}

// will fix all the errors later!