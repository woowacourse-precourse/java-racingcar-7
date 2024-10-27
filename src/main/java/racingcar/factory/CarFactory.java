package racingcar.factory;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class CarFactory {

    public static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

}
