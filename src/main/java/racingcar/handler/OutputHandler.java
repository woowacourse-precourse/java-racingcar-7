package racingcar.handler;

import static racingcar.constants.FormatConstants.NEXT_LINE;
import static racingcar.constants.Messages.CARS_NAME_INPUT_MESSAGE;
import static racingcar.constants.Messages.EXEC_RESULT_MESSAGE;
import static racingcar.constants.Messages.TOTAL_ROUNDS_INPUT_MESSAGE;
import static racingcar.constants.Messages.WINNER_INFO_HEADER;

import racingcar.dto.RoundResult;
import racingcar.dto.Winners;
import racingcar.utils.DisplayConverter;

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
        System.out.println(DisplayConverter.convertRoundResult(roundResult) + NEXT_LINE);
    }

    public static void displayWinners(Winners winners) {
        System.out.println(WINNER_INFO_HEADER + DisplayConverter.convertWinners(winners));
    }
}
