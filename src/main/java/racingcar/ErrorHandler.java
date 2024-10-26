package racingcar;

public class ErrorHandler {
    public static void printAndThrow(String message) {
        Printer.printMessage(message);
        throw new IllegalArgumentException();
    }
}