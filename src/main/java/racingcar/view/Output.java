package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class Output {
    public void printCarLocation(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + ":" + "-".repeat(car.getLocation()));
            System.out.println();
        }
    }
}
