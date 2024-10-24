package racingcar.entity;

import java.util.List;
import racingcar.exception.ExceptionUtils;
import racingcar.exception.RaceCarValidationError;
import racingcar.util.RandomNumberGenerator;

public class Race {
    final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
        validate(cars);
    }

    public void runSingleRound(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : this.cars) {
            car.move(randomNumberGenerator.pickRandomNumberInRange(0, 9));
        }
    }

    public String[] getWinners() {
        int maxPosition = this.cars
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalStateException::new);

        return this.cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toArray(String[]::new);
    }

    public String[] getCarNames() {
        return this.cars.stream().map(Car::getName).toArray(String[]::new);
    }

    private void validate(List<Car> cars) {
        if (cars == null) {
            ExceptionUtils.throwIllegalArgException(RaceCarValidationError.CARS_NULL);
        } else if (10 < cars.size()) {
            ExceptionUtils.throwIllegalArgException(RaceCarValidationError.CARS_EXCEED_LIMIT);
        } else if (cars.stream().map(Car::getName).distinct().count() != cars.size()) {
            ExceptionUtils.throwIllegalArgException(RaceCarValidationError.CARS_DUPLICATE_NAME);
        }
    }
}
