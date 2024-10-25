package racingcar.util;

public abstract class OutputHandler {

    public static void printResultMessage() {
        Printer.newLine();
        Printer.print(SystemMessage.RESULT_MESSAGE);
    }
}
