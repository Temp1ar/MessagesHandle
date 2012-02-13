import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Message writer which prints message to file in following format:
 * <code>
 *     n # of lines in message
 *     Line 1
 *     Line 2
 *     ...
 *     Line n
 * </code>
 */
public class FileMessageWriter implements MessageWriter {
    private BufferedWriter out;

    /**
     * Constructs the object using buffered writer
     * @param out buffered writer for target file
     * @throws IOException if IO error occurs
     */
    public FileMessageWriter(BufferedWriter out) throws IOException {
        this.out = out;
        ensureOpen();
    }

     /**
     * Ensures that buffered writer still opened
     * @throws IOException if IO error occurs
     */
    private void ensureOpen() throws IOException {
        if (out == null) {
            throw new IOException("Buffered writer closed");
        }
    }

    /**
     * Writes message to file
     * @param message message to write
     * @throws IOException if IO error occurs
     */
    public void writeMessage(Message message) throws IOException {
        ensureOpen();
        out.write(message.getLines().size() + "");
        out.newLine();
        for(int i = 0; i < message.getLines().size(); i++) {
            out.write(message.getLine(i));
            out.newLine();
        }
    }
}
