import java.io.IOException;

/**
 * Class that "compress" two messages in one through buffer.
 */
public class CompressingMessageWriter implements MessageWriter {
    private MessageWriter writer = null;
    private Message buffer = null;

    /**
     * Constructs the object with desired message writer
     * @param writer desired message writer
     */
    public CompressingMessageWriter(MessageWriter writer) {
        this.writer = writer;
    }

    /**
     * Fills the buffer if its empty. If the buffer is not empty
     * method appends second message to buffer and flushes it.
     * @param message message to write
     * @throws IOException if IO error occurs
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
     * @throws IOException if IO error occurs
     */
    public void flushBuffer() throws IOException {
        if(buffer != null) {
            writer.writeMessage(buffer);
            buffer = null;
        }
    }
}