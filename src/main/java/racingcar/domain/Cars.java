package racingcar.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.global.exception.CustomException;
import racingcar.global.exception.ErrorMessage;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
        validCars();
    }

    public void playSingleRound() {
        for (Car car : cars) {
            car.tryMove();
        }
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(car -> car.getName() + " : " + "-".repeat(Math.max(0, car.getMoveCount())) + "\n")
                .collect(Collectors.joining());
    }

    public List<Car> getWinners() {
        int maxMoveCount = getMaxMoveCount();
        return cars.stream().filter(it -> it.getMoveCount() == maxMoveCount).toList();
    }

    private void validCars() {
        if (hasDuplicateCarNames(cars)) {
            throw CustomException.of(ErrorMessage.DUPLICATE_CAR_NAME_ERROR);
        }
    }

    private int getMaxMoveCount() {
        return cars.stream().mapToInt(Car::getMoveCount).max().orElse(0);
    }

    private boolean hasDuplicateCarNames(List<Car> cars) {
        Set<String> carUniqueNames = cars.stream().map(Car::getName).collect(Collectors.toSet());
        return carUniqueNames.size() != cars.size();
    }
}
