package racingcar.service;

import racingcar.util.RandomGenerator;
import racingcar.vo.Car;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingGameService {

    private static final int MOVING_FORWARD = 4;
    private RandomGenerator randomGenerator;

    public RacingGameService(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public List<String> getWinner(Set<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void moveCars(Set<Car> cars) {
        cars.stream()
                .filter(this::shouldMoveForward)
                .forEach(Car::forward);
    }

    private int getMaxPosition(Set<Car> cars) {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .map(Car::getPosition)
                .orElse(0);
    }

    private boolean shouldMoveForward(Car car) {
        return randomGenerator.generateNumber() >= MOVING_FORWARD;
    }

}
