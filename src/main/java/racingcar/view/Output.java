package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class Output {

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }
}
