package racingcar.model;

import java.util.List;
import racingcar.ErrorMessage;

public class RaceCars {
    private final List<Car> cars;

    public RaceCars(final List<Car> cars) {
        validateDuplicatedCars(cars);
        if (hasInappropriateNumberOfCars(cars)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RACINGCAR_NUMBER.getMessage());
        }
        this.cars = cars;
    }

    private boolean hasInappropriateNumberOfCars(List<Car> cars) {
        return cars.size() < 2;
    }

    private void validateDuplicatedCars(List<Car> cars) {
        long distinctCarNumber = cars.stream().distinct().count();
        if (distinctCarNumber != cars.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_RACINGCAR.getMessage());
        }
    }
}
