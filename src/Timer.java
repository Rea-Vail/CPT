/*
 * @Author: Arwin Lado
 * Date: 13/01/2025
 * Timer class 
 */

 /* This is the timer class that will return the time of the user typing words and words per minute
  * 
  */
public class Timer {
    // Creates instance variables for the timer class and adding the long method
    private long startTime;
    private long endTime;

    // constructor for the timer
    public Timer() {
        this.startTime = 0;
        this.endTime = 0;
    }

    // adds a public void for the start time
    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    // adds a public void for the end time
    public void end() {
        this.endTime = System.currentTimeMillis();
    }

    // adds a public long for the get time
    // It then returns the end time minus the start time
    public long getTime() {
        return endTime - startTime;
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
