package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class StatusView {
    public static void printStatus(List<Car> cars) {
        cars.forEach(Car::getStatus);
        System.out.println();
    }
}
