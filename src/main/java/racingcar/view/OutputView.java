package racingcar.view;

public class OutputView {

    public static void printMessage(PrintMessage printMessage) {
        System.out.print(printMessage.getMessage());
    }

    public static void printMessageWithLine(PrintMessage printMessage) {
        System.out.println(printMessage.getMessage());
    }
}
