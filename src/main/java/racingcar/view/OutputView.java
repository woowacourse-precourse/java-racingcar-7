package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public void printExecutionResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printCurrentRoundRacingResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getForwardCount()));
        }
        System.out.println();
    }
}
