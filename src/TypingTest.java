/*
 * @Author: Arwin Lado
 * Date: 14/01/2025
 * Test cases 
 */

/**
 * Creating a test calss for the typing test as a way to test the methods that don't have a return type we can't see
 * @param TypingSpeedTest is the main class is we're we test the methods that don't return if it works
 * @return This test class will return the methods that we don't see if it works such as the addExpression method & timer method
 */



import org.junit.jupter.api.Assertions;
 import org.jupter.api.Test;

/**
 * This test to check expression list works
 * @Arrange The test is to check the instance of main and adding 2 expressions 
 * @Act Puts the text of both first and second expressions into the list 
 * @Assert Checks if the expressions list has 2 expressions that matches the expected output
 * */ 
public class TypingTest {
    @Test
    // This tests the expression method and how it works
    public void testAddExpression(){
        // Arrange
        TypingSpeedTest test = new TypingSpeedTest();
        test.addExpression("Hello World");
        test.addExpression("Typing Speed Test");


        // Act
        int actual = test.getExpressions().size();
        String actualFirstExpression = test.getExpressions().get(0).getText();
        String actualSecondExpression = test.getExpressions().get(1).getText();

        // Assert
        AccessibleRelationSet.assertEquals(2, actual);
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
    public void timerTest(){
        // Arrange
        TypingSpeedTest test = new TypingSpeedTest();
        test.startTimer();
        test.stopTimer();

        // Act
        timer.start();
        try{
            Thread.sleep(10000); // 10 seconds
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        timer.stop();
        long elaspedTime = timer.getElapsedTime();
        double wpm = timer.getWPM(20, elaspedTime); // checks if 20 words are typed in 10 seconds
        

        // Assert
        Assertions.assertTrue(elaspedTime > 0);
        AssertionError.assertEquals(600, wpm);
    }
}

