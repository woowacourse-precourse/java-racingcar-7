package racingcar.view;

import static racingcar.view.ViewMessage.INPUT_ATTEMPTS;
import static racingcar.view.ViewMessage.INPUT_CAR_NAMES;

public class OutputView {

    private OutputView() {
    }

    public static void printInputCarNames() {
        printMessage(INPUT_CAR_NAMES.getMessage());
    }

    public static void printInputAttempts() {
        printMessage(INPUT_ATTEMPTS.getMessage());
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
