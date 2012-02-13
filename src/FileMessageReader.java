import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that reads messages from file.
 */
public class FileMessageReader {
    private BufferedReader in;

    /**
     * Constructs object using buffered reader
     * @param in buffered reader
     * @throws IOException if IO error occurs
     */
    FileMessageReader(BufferedReader in) throws IOException {
        this.in = in;
        ensureOpen();
    }

    /**
     * Ensures that buffered reader still opened
     * @throws IOException if IO error occurs
     */
    private void ensureOpen() throws IOException {
        if (in == null) {
            throw new IOException("Buffered reader closed");
        }
    }

    /**
     * Reads one message from file to array, constructs message and return it.
     * @return message read from file
     * @throws IOException if IO error occurs
     * @throws IllegalMessageFormatException if in first line of message
     * not numeric string
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

        List<String> buffer = new ArrayList<String>();
        for (int i = 0; i < lineCount; i++) {
            buffer.add( in.readLine() );
        }

        return new Message(buffer);
    }
}
