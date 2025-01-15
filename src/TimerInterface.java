/*
 * @Author: Arwin Lado
 * Date: 15/01/2025
 * Expression class 
 */

 /**
  * This class is a interface for timer were
  * @param start() method that will start the timer
  * @param stop() method that will stop the timer
  * @return The given time, elasped time and wpm
  * It works as a way for the user to his/her improvement
  **/


public interface TimerInterface {
    void start();
    void stop();
    long getElapsedTime();
    double calculateWPM(int wordCount);
}
