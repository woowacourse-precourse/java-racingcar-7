package racingcar.entity;

import java.util.List;
import racingcar.Config;
import racingcar.exception.ExceptionUtils;
import racingcar.exception.RaceValidationError;
import racingcar.util.RandomNumberGenerator;

public class Race {
    private final List<Car> cars;
    private final RaceHistory raceHistory;

    private Race() {
        this.cars = null;
        this.raceHistory = null;
    }

    public Race(List<Car> cars) {
        this.cars = cars;
        this.raceHistory = new RaceHistory();
        validate(cars);
    }

    public void runSingleRound(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : this.cars) {
            car.move(randomNumberGenerator.pickRandomNumberInRange(Config.RANDOM_NUMBER_BEGIN.getValue(),
                    Config.RANDOM_NUMBER_END.getValue()));
        }
        this.raceHistory.addRound(this.cars);
    }

    public RaceHistory getRaceHistory() {
        return this.raceHistory;
    }

    public List<Car> getCars() {
        return this.cars;
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
        } else if (Config.NUMBER_OF_CAR_LIMIT.getValue() < cars.size()) {
            ExceptionUtils.throwIllegalArgException(RaceValidationError.CARS_EXCEED_LIMIT);
        } else if (cars.stream().map(Car::getName).distinct().count() != cars.size()) {
            ExceptionUtils.throwIllegalArgException(RaceValidationError.CARS_DUPLICATE_NAME);
        }
    }
}
