package racingcar.view;

import static racingcar.view.constants.ViewMessage.OUTPUT_RESULT;

public class OutputView {

    public static void printWinner(final String winners) {
        String winnerName = String.format(OUTPUT_RESULT.getMessage(), winners);
        System.out.println(winnerName);
    }
}
