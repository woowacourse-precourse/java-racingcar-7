package racingcar.view;

import java.util.List;
import racingcar.domain.Cars;

public class ResultView {
    public static void promptExecutionResult() {
        System.out.print("실행 결과\n");
    }

    public static void showTurnResult(Cars cars) {
        System.out.println(cars + "\n");
    }

    public static void showWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}
