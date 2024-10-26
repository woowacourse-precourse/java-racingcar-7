package racingcar.entity;

import java.util.List;
import racingcar.exception.ExceptionUtils;
import racingcar.exception.RaceValidationError;
import racingcar.util.RandomNumberGenerator;

public class Race {
    public static final int NUMBER_OF_CAR_LIMIT = 10;
    public static final int RANDOM_NUMBER_BEGIN = 0;
    public static final int RANDOM_NUMBER_END = 9;

    final List<Car> cars;

    private Race() {
        this.cars = null;
    }

    public Race(List<Car> cars) {
        this.cars = cars;
        validate(cars);
    }

    public void runSingleRound(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : this.cars) {
            car.move(randomNumberGenerator.pickRandomNumberInRange(RANDOM_NUMBER_BEGIN, RANDOM_NUMBER_END));
        }
    }

    public List<String> getWinners() {
        int maxPosition = this.cars
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalStateException::new);

        return this.cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    public List<String> getCarNames() {
        return this.cars.stream().map(Car::getName).toList();
    }

    private void validate(List<Car> cars) {
        if (cars == null) {
            ExceptionUtils.throwIllegalArgException(RaceValidationError.CARS_NULL);
        } else if (NUMBER_OF_CAR_LIMIT < cars.size()) {
            ExceptionUtils.throwIllegalArgException(RaceValidationError.CARS_EXCEED_LIMIT);
        } else if (cars.stream().map(Car::getName).distinct().count() != cars.size()) {
            ExceptionUtils.throwIllegalArgException(RaceValidationError.CARS_DUPLICATE_NAME);
        }
    }
}
