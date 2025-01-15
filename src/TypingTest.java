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

public class TypingTest {
    @Test
    // This tests the expression method and how it works
    public void testAddExpression() {
        // Arrange
        TypingSpeedTest test = new TypingSpeedTest();
        test.addExpression("Hello World");
        test.addExpression("Typing Speed Test");

        // Act
        int actual = test.getExpressions().size();
        String actualFirstExpression = test.getExpressions().get(0).getText();
        String actualSecondExpression = test.getExpressions().get(1).getText();

        // Assert
        Assertions.assertEquals(2, actual);
        Assertions.assertEquals("Hello World", actualFirstExpression);
        Assertions.assertEquals("Typing Speed Test", actualSecondExpression);
    }

    @Test
    // This tests if the timer method works
    public void timerTest() {
        // Arrange
        Timer timer = new Timer();
        timer.start();
        try {
            Thread.sleep(10000); // 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.stop();
        long elapsedTime = timer.getElapsedTime();
        double wpm = timer.calculateWPM(20); // checks if 20 words are typed in 10 seconds

        // Assert
        Assertions.assertTrue(elapsedTime > 0);
        Assertions.assertEquals(120, wpm); // 20 words in 10 seconds is 120 WPM
    }
}