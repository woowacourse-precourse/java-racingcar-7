package racingcar.util;

public abstract class OutputHandler {

    public static void printResultMessage() {
        Printer.breakLine();
        Printer.print(SystemMessage.RESULT_MESSAGE);
    }
}
