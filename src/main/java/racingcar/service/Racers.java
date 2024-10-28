package racingcar.service;

import static racingcar.View.ViewConstants.DUPLICATE_NAME_ERROR_MESSAGE;
import static racingcar.View.ViewConstants.NOT_ENOUGH_PLAYERS_ERROR_MESSAGE;
import static racingcar.config.RacingConstants.REQUIRED_MIN_PLAYERS;

import java.util.List;

public class Racers {
    private final List<Car> cars;

    public Racers(List<Car> cars) {
        validateCountOf(cars);
        validateNonDuplicate(cars);
        this.cars = cars;
    }

    private void validateCountOf(List<Car> cars) {
        if (cars.size() < REQUIRED_MIN_PLAYERS) {
            throw new IllegalArgumentException(NOT_ENOUGH_PLAYERS_ERROR_MESSAGE);
        }
    }

    private void validateNonDuplicate(List<Car> cars) {
        long totalDistinctNames = cars.stream().map(Car::getName).distinct().count();
        if (cars.size() != totalDistinctNames) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

    public void tryToMoveWith(RacingRule racingRule) {
        for (Car car : cars) {
            car.moveForwardIf(racingRule.permitToMove());
        }
    }

    public List<String> getCurrentResult() {
        return cars.stream()
                .map(Car::getStatus)
                .toList();
    }

    public List<String> getWinnerNames() {
        Car maxMoveCountCar = findMaxMoveCountCar();
        return findSameMoveCountCar(maxMoveCountCar);
    }

    private List<String> findSameMoveCountCar(Car maxMoveCountCar) {
        return cars.stream()
                .filter(maxMoveCountCar::isSameMoveCount)
                .map(Car::getName)
                .toList();
    }

    private Car findMaxMoveCountCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow();
    }
}