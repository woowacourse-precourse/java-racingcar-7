package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarCreator {

    private CarCreator() {
    }

    public static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

}
