package racingcar.model.factory;

import racingcar.model.Car;

import java.util.List;

public class CarFactory {

    public static List<Car> convertToCar(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }
}
