package racingcar;

import static racingcar.constants.Messages.CARS_NAME_INPUT_MESSAGE;
import static racingcar.constants.Messages.EXEC_RESULT_MESSAGE;
import static racingcar.constants.Messages.TOTAL_ROUNDS_INPUT_MESSAGE;
import static racingcar.constants.Messages.WINNER_INFO_HEADER;

public class OutputHandler {

    public static void displayCarsNameInputMessage() {
        System.out.println(CARS_NAME_INPUT_MESSAGE);
    }

    public static void displayTotalRoundsInputMessage() {
        System.out.println(TOTAL_ROUNDS_INPUT_MESSAGE);
    }

    public static void displayExecResultMessage() {
        System.out.println(EXEC_RESULT_MESSAGE);
    }

    public static void displayRoundResult(RoundResult roundResult) {
        System.out.println(DisplayConverter.convertRoundResult(roundResult));
    }

    public static void displayWinners(Winners winners) {
        System.out.println(WINNER_INFO_HEADER+DisplayConverter.convertWinners(winners));
    }
}
