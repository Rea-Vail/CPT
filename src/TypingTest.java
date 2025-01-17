/*
 * @Author: Arwin Lado
 * Date: 14/01/2025
 * Test cases 
 */

/**
 * Creating a test class for the typing test as a way to test the methods that don't have a return type we can't see
 * @param TypingSpeedTest is the main class is we're we test the methods that don't return if it works
 * @return This test class will return the methods that we don't see if it works such as the addExpression method & timer method
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This test to check expression list works
 * @Arrange The test is to check the instance of main and adding 2 expressions 
 * @Act Puts the text of both first and second expressions into the list 
 * @Assert Checks if the expressions list has 2 expressions that matches the expected output
 * */ 
public class TypingTest {
    @Test
    // This tests the expression method and how it works
    public void testAddExpression() {
        // Arrange
        TypingSpeedTest test = new TypingSpeedTest();
        test.addExpression("Hello World");
        test.addExpression("Typing Speed Test");

        // Act
        int actual = test.getExpressions().size(); // returns the size of the list
        String actualFirstExpression = test.getExpressions().get(0).getText();
        String actualSecondExpression = test.getExpressions().get(1).getText();

        // Assert
        Assertions.assertEquals(2, actual);
        Assertions.assertEquals("Hello World", actualFirstExpression);
        Assertions.assertEquals("Typing Speed Test", actualSecondExpression);
    }
/**
 * This test to check if the instance of timer works  
 * @Arrange Creates the instances for the timer
 * @Act It starts the timer and simulates the delay of 2 seconds. It then stops the timer to check the elasped time.
 * It also calculates the Words per minute(WPM) by checking if 20 words are typed in 2 seconds
 * @Assert Checks if the expressions list has 2 expressions that matches the expected output
 * */
     @Test
     // This tests if the timer method works
     public void timerTest() {
     // Arrange
     Timer timer = new Timer();
     timer.start();
    
     /**
      * This pauses the application for 10 seconds to simulate the user typing
      * The try-catch method below allows the program to pause for 10 seconds via threat.sleep(10000)
      * If ever the application is interrupted while in waiting it will catch the interrauptioend exception
      * It then prints out the error message being printstacktrace.
      *
      * @param Thread.sleep(2000) is used to simulate the delay of 2 seconds
      * @return The application will pause for 2 seconds
      */
    
     // Act
     // https://www.geeksforgeeks.org/difference-between-try-catch-and-if-else-statements-in-php/ 
     try {
        Thread.sleep(5000); // 5 seconds
     } catch (InterruptedException e) {
        e.printStackTrace();
     }
     timer.stop();
     long elapsedTime = timer.getElapsedTime();
     double wpm = timer.calculateWPM(5); // checks if 20 words are typed in 10 seconds

     // Assert
     Assertions.assertTrue(elapsedTime >= 5000);
     Assertions.assertEquals(59.97600959616153, wpm); // 20 words in 10 seconds is 119 WPM
 }
}