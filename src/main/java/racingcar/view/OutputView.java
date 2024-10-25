package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public void outputRaceStartLine() {
        System.out.println("\n실행 결과");
    }

    public void outputRaceIntermediateReuslt(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName()+ " : " + "-".repeat(car.getMoveDistance()));
        }
        System.out.println();
    }
}
