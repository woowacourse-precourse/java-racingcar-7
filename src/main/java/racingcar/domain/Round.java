package racingcar.domain;

import java.util.List;

public class Round {
    private final List<Car> cars;

    public Round(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> pickWinners() {
        int maxPosition = getWinnerPosition();
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .toList();
    }

    public List<Car> getCars() {
        return cars.stream()
                .toList();
    }

    private int getWinnerPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
