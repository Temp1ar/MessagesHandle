public class ConsoleMessageWriter implements MessageWriter {
    public void writeMessage(Message message) {
        WrittenMessageCounter counter = WrittenMessageCounter.getInstance();
        counter.increment();

        System.out.println("Message " + counter);

        for(int i = 0; i < message.getLines().size(); i++) {
            System.out.println(counter + "." + (i+1) + ". " +
                    message.getLine(i));
            // TODO: or message.getLines().get(i)?
        }
    }
}
