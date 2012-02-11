import java.io.*;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = null;
        String outputFilePath = null;

        switch(args.length) {
            case 0:
                System.err.println("Not enough arguments.");
                System.exit(1);
                break;
            case 1:
                inputFilePath = args[0];
                break;
            case 2:
                inputFilePath = args[0];
                outputFilePath = args[1];
                break;
        }

        try(
            BufferedReader input =
                    new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter output = (outputFilePath != null) ?
                    new BufferedWriter(new FileWriter(outputFilePath)) :
                    null;
            )
        {
            FileMessageReader messageReader = new FileMessageReader(input);
            MessageWriter targetWriter = (output == null) ?
                    new ConsoleMessageWriter():
                    new FileMessageWriter(output);

            CompressingMessageWriter compressor =
                    new CompressingMessageWriter(targetWriter);

            try {
                Message message;
                while ((message = messageReader.readMessage()) != null) {
                    compressor.writeMessage(message);
                }
                compressor.flushBuffer();

            } catch (IllegalMessageFormatException|IOException e) {
                System.err.println(e);
            }

        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}