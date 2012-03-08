package ru.spbau.korovin.task1;

import java.io.IOException;

/**
 * Class that "compress" two messages in one through buffer.
 */
public class CompressingMessageWriter implements MessageWriter {
    private MessageWriter writer = null;
    private Message buffer = null;

    /**
     * Constructs the object with desired message writer
     * @param writer Desired message writer
     */
    public CompressingMessageWriter(MessageWriter writer) {
        this.writer = writer;
    }

    /**
     * Fills the buffer if its empty. If the buffer is not empty
     * method appends second message to buffer and flushes it.
     * @param message Message to write
     * @throws IOException If IO error occurs
     */
    public void writeMessage(Message message) throws IOException {
        if(buffer == null) {
            buffer = new Message(message);
        } else {
            buffer.append(message);
            flushBuffer();
        }
    }

    /**
     * Flushes internal buffer
     * @throws IOException If IO error occurs
     */
    public void flushBuffer() throws IOException {
        if(buffer != null) {
            writer.writeMessage(buffer);
            buffer = null;
        }
    }

    /**
     * Closes this stream and releases any system resources associated
     * with it. If the stream is already closed then invoking this
     * method has no effect.
     *
     * @throws java.io.IOException if an I/O error occurs
     */
    @Override
    public void close() throws IOException {
        writer.close();
    }
}