import java.io.IOException;

/**
 * Interface for different message writers.
 */
public interface MessageWriter {
    /**
     * Writes message somewhere.
     * @param message message to write
     * @throws IOException throws if there any IO error occurs
     */
    void writeMessage(Message message) throws IOException;
}
