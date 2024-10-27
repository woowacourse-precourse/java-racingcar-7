package racingcar.model;

import java.util.List;
import racingcar.ErrorMessage;

public class RaceCars {
    private final List<Car> cars;

    public RaceCars(final List<Car> cars) {
        if (hasInappropriateNumberOfCars(cars)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RACINGCAR_NUMBER.getMessage());
        }
        this.cars = cars;
    }

    private boolean hasInappropriateNumberOfCars(List<Car> cars) {
        return cars.size() < 2;
    }
}
