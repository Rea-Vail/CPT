/*
 * @Author: Arwin Lado
 * Date: 13/01/2025
 * Timer class 
 */

/** This is the timer class that will return the time of the user typing words and words per minute
 * @param long is a data type that represents the time, it a datatype I found on the internet 
 * @return long returns the time of the user typing the words and words per minute
 * 
 **/
public class Timer implements TimerInterface {
    // Creates instance variables for the timer class and adding the long method
    private long startTime;
    private long endTime;

    // constructor for the timer
    public Timer() {
        this.startTime = 0;
        this.endTime = 0;
    }

    /**
     * Starts the timer by recording the current system time in milliseconds.
     */
    @Override
    public void start() {
        startTime = System.currentTimeMillis();
    }

     /**
     * Stops the timer by recording the current system time in milliseconds.
     */    
    @Override
    public void stop() {
        endTime = System.currentTimeMillis();
    }

    /**
     * Calculates the elapsed time between the start and stop of the timer.
     * 
     * @return the elapsed time in milliseconds.
     */
    @Override
    public long getElapsedTime() {
        return endTime - startTime;
    }

    /**
    * This method calculates the words per minute of the user and time remaining
    * @param wordCount How many words the user has typed and counts it
    * @return This method will return the words per minute of the user by dividing the words counted and total minutes
    */
    @Override
    public double calculateWPM(int wordCount) {
        long elapsedTimeMillis = getElapsedTime();

        // this is the formula for calculating words per minute
        // example 200 words / 2 minutes = 100 words per minute
        double elapsedTimeMinutes = elapsedTimeMillis / 60000.0; // converted milliseconds to minutes
        return wordCount / elapsedTimeMinutes;
    }    
}