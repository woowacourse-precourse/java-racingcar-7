package racingcar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarManager {

    private final List<Car> cars;

    public CarManager(final String[] carNames) {
        CarValidator.validateDuplicateCarName(carNames);
        this.cars = initializeCars(carNames);
    }

    private List<Car> initializeCars(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
