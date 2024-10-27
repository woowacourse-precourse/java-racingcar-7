package racingcar.view;

import static racingcar.constants.Constants.COMMA_SPACE;
import static racingcar.constants.Constants.START_INDEX;
import static racingcar.constants.Constants.TRIM_LENGTH;

import java.util.List;
import racingcar.constants.OutputMessages;

public class OutputView {
    private OutputView() {

    }

    public static void printInsertRacersName() {
        System.out.println(OutputMessages.INSERT_RACERS_NAME);
    }

    public static void printInsertTryCount() {
        System.out.println(OutputMessages.INSERT_TRY_COUNT);
    }

    public static void printGameResultMessage() {
        System.out.println();
        System.out.println(OutputMessages.RACING_RESULT);
    }

    public static void printFinalWinner(List<String> finalWinners) {
        System.out.print(OutputMessages.FINAL_WINNER);
        StringBuilder result = new StringBuilder();

        for (String winner : finalWinners) {
            result.append(winner).append(COMMA_SPACE);
        }

        System.out.println(result.substring(START_INDEX, result.length() - TRIM_LENGTH));
    }

    public static void printRacingResult(String racingResult) {
        System.out.print(racingResult);
    }
}
