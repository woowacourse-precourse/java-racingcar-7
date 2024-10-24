package racingcar.model;

import java.util.List;
import java.util.stream.Stream;
import racingcar.domain.Car;

public class CarMaker {

    public List<Car> makeCars(String carNames) {
        return Stream.of(carNames.split(","))
                .map(String::trim)
                .map(Car::new)
                .toList();
    }
}
