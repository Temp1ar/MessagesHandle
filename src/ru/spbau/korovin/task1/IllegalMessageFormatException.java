package ru.spbau.korovin.task1;

/**
 * Exception class for illegal message format
 */
public class IllegalMessageFormatException extends Exception {
    private static final long serialVersionUID = 1L;
    /**
     * Constructs exception object with error message (??)
     * @param message Error message
     */
    public IllegalMessageFormatException(String message) {
        super(message);
    }
}
