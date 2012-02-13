/**
 * Message writer which prints message to console in following format:
 * <code>
 *     Message #
 *     #.1 Line 1
 *     #.2 Line 2
 *     ...
 * </code>
 */
public class ConsoleMessageWriter implements MessageWriter {
    /**
     * Writes message to console
     * @param message message to write
     */
    public void writeMessage(Message message) {
        WrittenMessageCounter counter = WrittenMessageCounter.getInstance();
        counter.increment();

        System.out.println("Message " + counter);

        for(int i = 0; i < message.getLines().size(); i++) {
            System.out.println(counter + "." + (i+1) + ". " +
                    message.getLine(i));
        }
    }
}
