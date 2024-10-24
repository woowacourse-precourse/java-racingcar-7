package racingcar.view;

import java.util.List;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printWinners(String message, List<String> winners) {
        String result = String.join(",", winners);
        System.out.println(message + result);
    }
}
