package racingcar.view;

import java.util.List;
import racingcar.model.Cars;

public class OutputView {
    private static final String RACE_RESULT = "\n실행 결과";
    private static final String RACE_WINNER = "최종 우승자 : ";

    public static void printRaceResult() {
        System.out.println(RACE_RESULT);
    }

    public static void printRaceProgress(Cars cars) {
        System.out.println(cars);
    }

    public static void printRaceWinner(List<String> raceWinner) {
        System.out.println(RACE_WINNER + String.join(", ", raceWinner));
    }
}
