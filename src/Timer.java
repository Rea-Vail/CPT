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
class Timer implements TimerInterface {
    // Implemented a long data type that basically represents the int values of the
    // time
    // I got this data type from this
    // https://www.w3schools.com/java/java_data_types.asp
    private long startTime;
    private long endTime;

    /**
     * Starts the timer by recording the current system time in milliseconds.
     */
    public void start() {
        startTime = System.currentTimeMillis();
    }

    /**
     * Stops the timer by recording the current system time in milliseconds.
     */
    public void stop() {
        endTime = System.currentTimeMillis();
    }

    /**
     * Calculates the elapsed time between the start and stop of the timer.
     * 
     * @return the elapsed time in milliseconds.
     */
    public long getElapsedTime() {
        return endTime - startTime;
    }

    /**
     * Calculates the words per minute (WPM) based on the number of words typed and the elapsed time.
     * 
     * @param wordCount the number of words typed by the user.
     * @return the words per minute (WPM) calculated.
     */
    public double calculateWPM(int wordCount) {
        long elapsedTimeMillis = getElapsedTime();
        double elapsedTimeMinutes = elapsedTimeMillis / 60000.0;
        return wordCount / elapsedTimeMinutes;
    }
}