package racingcar.view;

import java.util.List;
import racingcar.domain.Cars;

public class ResultView {

    private static final String WINNERS_SEPARATOR = ", ";

    public static void promptExecutionResult() {
        System.out.println("\n실행 결과");
    }

    public static void showTurnResult(Cars cars) {
        System.out.println(cars);
    }

    public static void showWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + joinWinnerNames(winners));
    }

    private static String joinWinnerNames(List<String> winners) {
        return String.join(WINNERS_SEPARATOR, winners);
    }
}
