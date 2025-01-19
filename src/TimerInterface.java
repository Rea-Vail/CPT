/*
 * @Author: Arwin Lado
 * Date: 15/01/2025
 * Expression class 
 */

 /**
  * This class is a interface for timer that will be used in the TypingTest class and it basically makes a new(fake) data type
  * - start(): Starts the timer.
  * - stop(): Stops the timer.
  * - getElapsedTime(): Gets the elapsed time in milliseconds.
  * - calculateWPM(int wordCount): Calculates the words per minute based on the word count and elapsed time.
  * @return The given time, elasped time and wpm It works as a way for the user to his/her improvement
  *
  **/
public interface TimerInterface {
    // Starts the timer
    void start();
    // ends the timer
    void stop();
    // get the elasped time
    long getElapsedTime();
    // gets the word per minute
    double calculateWPM(int wordCount);
}
