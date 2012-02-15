package ru.spbau.korovin.task1;

/**
 * Simple singleton class counter. Used to enumerate messages that were
 * written to console.
 */
public class WrittenMessageCounter {
    private static WrittenMessageCounter ourInstance =
            new WrittenMessageCounter();
    private int counter = 0;

    /**
     *  Returns instance of class
     * @return Instance of class
     */
    public static WrittenMessageCounter getInstance() {
        return ourInstance;
    }

    /**
     * Increments internal counter.
     */
    public void increment() {
        counter++;
    }

    /**
     *  Returns counter value as string.
     * @return The value of counter casted to string
     */
    public String toString() {
        return counter + "";
    }

    private WrittenMessageCounter() {
    }
}
