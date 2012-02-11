public class WrittenMessageCounter {
    private static WrittenMessageCounter ourInstance =
            new WrittenMessageCounter();
    private int counter = 0;

    public static WrittenMessageCounter getInstance() {
        return ourInstance;
    }

    public void increment() {
        counter++;
    }

    public String toString() {
        return counter + "";
    }

    private WrittenMessageCounter() {
    }
}
