package racingcar.utils;

import racingcar.domain.Car;

import java.util.List;

public class OutputHandler {

    public void printRoundResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
