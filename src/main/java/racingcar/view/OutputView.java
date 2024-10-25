package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public void outputRaceStartLine() {
        System.out.println("\n실행 결과");
    }

    public void outputRaceIntermediateResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName()+ " : " + "-".repeat(car.getMoveDistance()));
        }
        System.out.println();
    }

    public void outputRaceFinalResult(List<String> winnerNames) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }
}
