package ru.spbau.korovin.task1;

import java.io.*;

/**
 * The starting point of this application.
 */
public class Main {
    /**
     * First argument is the input file with bunch of messages. Application
     * reads messages one by one and after "compressing" writes it to the
     * output file(second argument) or to console.
     * @param args Arguments: args[0] input file, args[1] output file
     */
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
            default:
                inputFilePath = args[0];
                outputFilePath = args[1];
                break;
        }

        try(
            FileMessageReader messageReader =
                    new FileMessageReader(
                        new BufferedReader(new FileReader(inputFilePath)));
            MessageWriter targetWriter = (outputFilePath != null)
                    ? new FileMessageWriter(
                        new BufferedWriter(new FileWriter(outputFilePath)))
                    :  ConsoleMessageWriter.getInstance()
            )
        {

            CompressingMessageWriter compressor =
                    new CompressingMessageWriter(targetWriter);

            try {
                Message message;
                while ((message = messageReader.readMessage()) != null) {
                    compressor.writeMessage(message);
                }
                compressor.flushBuffer();

            } catch (IllegalMessageFormatException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
                e.printStackTrace(System.err);
            }

        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace(System.err);
        }
    }
}