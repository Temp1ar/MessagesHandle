import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileMessageReader {
    private BufferedReader in;

    FileMessageReader(BufferedReader in) throws IOException {
        this.in = in;
        ensureOpen();
    }

    private void ensureOpen() throws IOException {
        if (in == null) {
            throw new IOException("Buffered reader closed");
        }
    }

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
