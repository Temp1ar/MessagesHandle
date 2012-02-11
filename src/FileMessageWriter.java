import java.io.BufferedWriter;
import java.io.IOException;

public class FileMessageWriter implements MessageWriter {
    private BufferedWriter out;

    public FileMessageWriter(BufferedWriter out) throws IOException {
        this.out = out;
        ensureOpen();
    }

    private void ensureOpen() throws IOException {
        if (out == null) {
            throw new IOException("Buffered writer closed");
        }
    }

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
