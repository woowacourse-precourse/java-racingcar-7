package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String WINNER_DELIMITER = ", ";

    public static void print(String output) {
        System.out.print(output);
    }

    public static void newLinePrint(String output) {
        System.out.println(output);
    }

    public static void printWinners(String message, List<String> winners) {
        String result = String.join(WINNER_DELIMITER, winners);
        newLinePrint(message + result);
    }
}
