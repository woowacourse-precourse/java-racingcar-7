package racingcar.view;

import static racingcar.view.ViewMessage.INPUT_CAR_NAMES;

public class OutputView {

    private OutputView() {
    }

    public static void printInputCarNames() {
        printMessage(INPUT_CAR_NAMES.getMessage());
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
