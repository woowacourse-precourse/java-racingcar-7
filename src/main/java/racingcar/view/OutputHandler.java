package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputHandler {
    public static void printCarPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

}
