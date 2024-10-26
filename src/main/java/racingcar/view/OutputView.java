package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    private static final String MOVE_DISTANCE_SYMBOL = "-";

    public static void outputRaceStartLine() {
        System.out.println("\n실행 결과");
    }

    public static void outputRaceIntermediateResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(String.format("%s : %s"
                    , car.getName()
                    , MOVE_DISTANCE_SYMBOL.repeat(car.getMoveDistance())));
        }
        System.out.println();
    }

    public static void outputRaceFinalResult(List<String> winnerNames) {
        System.out.println(String.format("최종 우승자 : %s"
                , String.join(", ", winnerNames)));
    }
}
