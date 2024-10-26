package racingcar.model;

import java.util.List;
import racingcar.common.exception.CarException;
import racingcar.common.exception.CarValidationError;
import racingcar.common.utils.RandomNumberGenerator;

public class Cars {

    private static final int CAR_MIN_COUNT = 1;
    private static final int CAR_MAX_COUNT = 10;

    private final List<Car> values;

    public Cars(final List<Car> values) {
        validate(values);
        this.values = values;
    }

    public void runRace() {
        values.forEach(car -> car.race(RandomNumberGenerator.generate()));
    }

    public List<CarInformation> getAllCarsInformation() {
        return values.stream()
                .map(car -> new CarInformation(car.name(), car.position()))
                .toList();
    }

    public List<CarInformation> calculateWinners() {
        Car maxPositionCar = values.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new CarException(CarValidationError.CAR_NOT_FOUND_EXCEPTION.getMessage()));

        return values.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .map(car -> new CarInformation(car.name(), car.position()))
                .toList();
    }

    private void validate(final List<Car> values) {
        checkCountOfCars(values.size());
        checkDuplicatedCars(values);
    }

    private void checkCountOfCars(final int count) {
        if (count < CAR_MIN_COUNT) {
            throw new CarException(CarValidationError.LESS_THAN_MIN_CARS_COUNT_EXCEPTION.getMessage(CAR_MIN_COUNT));
        }
        if (count > CAR_MAX_COUNT) {
            throw new CarException(CarValidationError.EXCEEDS_MAX_CARS_COUNT_EXCEPTION.getMessage(CAR_MAX_COUNT));
        }
    }

    private void checkDuplicatedCars(final List<Car> values) {
        final long distinctCount = values.stream()
                .distinct()
                .count();
        if (distinctCount != values.size()) {
            throw new CarException(CarValidationError.DUPLICATED_CARS_EXISTS_EXCEPTION.getMessage());
        }
    }
}