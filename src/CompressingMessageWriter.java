import java.io.IOException;

public class CompressingMessageWriter implements MessageWriter {
    private MessageWriter writer = null;
    private Message buffer = null;

    public CompressingMessageWriter(MessageWriter writer) {
        this.writer = writer;
    }

    public void writeMessage(Message message) throws IOException {
        if(buffer == null) {
            buffer = new Message(message);
        } else {
            buffer.append(message);
            writer.writeMessage(buffer);
            buffer = null;
        }
    }

    public void flushBuffer() throws IOException {
        if(buffer != null) {
            writer.writeMessage(buffer);
            buffer = null;
        }
    }
}