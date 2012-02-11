import java.util.ArrayList;
import java.util.List;

public class Message {
    private List<String> contents;

    public Message(List<String> data) {
        contents = new ArrayList<String>();
        contents.addAll(data);
    }

    public Message(Message copy) {
        contents = new ArrayList<String>(copy.getLines());
    }

    public void append(Message appendix) {
        contents.addAll(appendix.getLines());
    }

    public List<String> getLines() {
        return contents;
    }

    public String getLine(int i) {
        return contents.get(i);
    }
}
