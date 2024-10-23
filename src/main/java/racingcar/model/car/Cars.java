package racingcar.model.car;

import java.util.List;
import java.util.Objects;
import racingcar.common.exception.ShouldNotBeNullException;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateNullObj(cars);
        this.cars = cars;
    }

    private void validateNullObj(final List<Car> cars) {
        boolean matched = cars.stream().anyMatch(Objects::isNull);
        if (matched) {
            throw new ShouldNotBeNullException();
        }
    }
}
