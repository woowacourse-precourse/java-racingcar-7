package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class RaceOutputView {
    public void printExecutionPrompt() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }
}
