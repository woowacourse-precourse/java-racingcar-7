package racingcar.model.car;

import java.util.List;
import java.util.Objects;
import racingcar.common.exception.ShouldNotBeNullException;

public class Cars {
    private final List<Car> cars;

    public static Cars of(final List<Car> cars) {
        return new Cars(cars);
    }

    private Cars(final List<Car> cars) {
        validateIsNotNull(cars);
        this.cars = cars;
    }

    public void move() {
        cars.forEach(Car::updateProgress);
    }


    private void validateIsNotNull(final List<Car> cars) {
        boolean matched = cars.stream().anyMatch(Objects::isNull);
        if (matched) {
            throw new ShouldNotBeNullException();
        }
    }
}
