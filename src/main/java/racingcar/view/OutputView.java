package racingcar.view;

import static racingcar.view.constants.ViewMessage.OUTPUT_RESULT;
import static racingcar.view.constants.ViewMessage.RACE_RESULT_TITLE;

public class OutputView {

    public static void printWinner(final String winners) {
        String winnerName = String.format(OUTPUT_RESULT.getMessage(), winners);
        System.out.println(winnerName);
    }

    public static void printRaceResultTitle() {
        System.out.println();
        System.out.println(RACE_RESULT_TITLE.getMessage());
    }

    public static void printRaceStatus(final String raceStatus) {
        System.out.println(raceStatus);
    }
}
