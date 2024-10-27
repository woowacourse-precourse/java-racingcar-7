package racingcar.service;

import racingcar.util.RandomGenerator;
import racingcar.vo.Car;

import java.util.List;

public class RacingGameService {

    private static final int MOVING_FORWARD_CONDITION = 4;

    public List<String> getWinner(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    public void moveCars(List<Car> cars) {
        cars.stream()
                .filter(this::shouldMoveForward)
                .forEach(Car::forward);
    }

    private int findMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    private boolean shouldMoveForward(Car car) {
        return RandomGenerator.generateNumber() >= MOVING_FORWARD_CONDITION;
    }

}
