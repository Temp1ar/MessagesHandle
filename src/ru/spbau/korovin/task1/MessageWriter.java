package ru.spbau.korovin.task1;

import java.io.IOException;

/**
 * Interface for different message writers.
 */
public interface MessageWriter {
    /**
     * Writes message somewhere.
     * @param message Message to write
     * @throws IOException throws if there any IO error occurs
     */
    void writeMessage(Message message) throws IOException;
}
