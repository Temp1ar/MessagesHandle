import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that handles messages. Message is an array of strings.
 */
public class Message {
    /**
     * An array which stores all lines of current message.
     */
    private List<String> contents;

    /**
     * Constructs the message from array of strings.
     * @param data array of strings
     */
    public Message(List<String> data) {
        contents = new ArrayList<String>();
        contents.addAll(data);
    }

    /**
     * Copy constructor.
     * @param copy message object to copy
     */
    public Message(Message copy) {
        contents = new ArrayList<String>(copy.getLines());
    }

    /**
     * Appends to the current message another message.
     * @param appendix Message to append
     */
    public void append(Message appendix) {
        contents.addAll(appendix.getLines());
    }

    /**
     * Returns the whole collection of strings.
     * @return array of strings
     */
    public List<String> getLines() {
        return Collections.unmodifiableList(contents);
    }

    /**
     * Gets the concrete line of the message.
     * @param i Line number
     * @return Line from contents array with index i.
     */
    public String getLine(int i) {
        return contents.get(i);
    }
}
