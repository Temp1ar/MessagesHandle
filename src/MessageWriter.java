import java.io.IOException;

public interface MessageWriter {
    void writeMessage(Message message) throws IOException;
}
