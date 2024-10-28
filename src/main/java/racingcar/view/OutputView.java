package racingcar.view;

public class OutputView {

    public static void printOutput(String format, String[] output) {
        System.out.printf(format, String.join(", ", output));
    }
}
