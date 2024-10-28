package racingcar.service;

import java.util.List;

public class Racers {
    private final List<Car> cars;

    public Racers(List<Car> cars) {
        this.cars = cars;
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