package racingcar.view;

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
        System.out.println(OutputMessages.RACING_RESULT);
    }

    public static void printFinalWinner(List<String> finalWinners) {
        System.out.print(OutputMessages.FINAL_WINNER);
        StringBuilder result = new StringBuilder();

        for (String winner : finalWinners) {
            result.append(winner).append(", ");
        }

        System.out.println(result.substring(0, result.length() - 2));
    }

    public static void printRacingResult(String racingResult) {
        System.out.println(racingResult);
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
