package ru.spbau.korovin.task1;

/**
 * Message writer(singleton) which prints message to console in following
 * format:
 * <blockquote><pre>
 * {@code
 * Message #
 * #.1 Line 1
 * #.2 Line 2
 * ...
 * }
 * </blockquote></pre>
 */
public class ConsoleMessageWriter implements MessageWriter {
    private static ConsoleMessageWriter ourInstance =
            new ConsoleMessageWriter();

    /**
     *  Returns instance of class
     * @return Instance of class
     */
    public static ConsoleMessageWriter getInstance() {
        return ourInstance;
    }

    /**
     * Writes message to console
     * @param message Message to write
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

    private ConsoleMessageWriter() {        
    }
}
