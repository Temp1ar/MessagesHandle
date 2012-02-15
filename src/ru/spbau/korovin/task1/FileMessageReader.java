package ru.spbau.korovin.task1;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that reads messages from file.
 */
public class FileMessageReader implements Closeable {
    private BufferedReader in;

    /**
     * Constructs object using buffered reader
     * @param in Buffered reader
     * @throws IOException If IO error occurs
     */
    FileMessageReader(BufferedReader in) throws IOException {
        this.in = in;
        ensureOpen();
    }

    /**
     * Ensures that buffered reader still opened
     * @throws IOException If IO error occurs
     */
    private void ensureOpen() throws IOException {
        if (in == null) {
            throw new IOException("Buffered reader closed");
        }
    }

    /**
     * Reads one message from file to array, constructs message and return it.
     * @return Message read from file
     * @throws IOException If IO error occurs
     * @throws IllegalMessageFormatException If in first line of message
     * not numeric string or count of lines in head of message do not match
     * actual line count.
     */
    public Message readMessage() throws IOException, IllegalMessageFormatException {
        Integer lineCount;

        ensureOpen();
        try {
            String line = in.readLine();
            if(line == null) {
                return null;
            }

            lineCount = Integer.parseInt( line );
        } catch(NumberFormatException e) {
            throw new IllegalMessageFormatException("First string of the " +
                    "message is not a number.");
        }

        List<String> buffer = new ArrayList<>();
        String line;
        for (int i = 0; i < lineCount; i++) {
            line = in.readLine();
            if(line == null) {
                throw new IllegalMessageFormatException("Incorrect number of" +
                    " strings in message.");
            } else {
                buffer.add( line );
            }
        }

        return new Message(buffer);
    }

    /**
     * Frees resources
     * @throws IOException If IO error occurs
     */
    public void close() throws IOException {
        if (in == null)
            return;
        in.close();
        in = null;
    }
}
