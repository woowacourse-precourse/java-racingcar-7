package racingcar.view;

import java.util.List;
import racingcar.constants.Constants;
import racingcar.domain.Cars;

public class ResultView {

    private static final String WINNERS_SEPARATOR = ", ";

    public static void promptExecutionResult() {
        System.out.println(Constants.EXECUTION_RESULT_PROMPT);
    }

    public static void showTurnResult(Cars cars) {
        System.out.println(cars);
    }

    public static void showWinners(List<String> winners) {
        System.out.println(Constants.FINAL_WINNERS_PROMPT + joinWinnerNames(winners));
    }

    private static String joinWinnerNames(List<String> winners) {
        return String.join(WINNERS_SEPARATOR, winners);
    }
}
