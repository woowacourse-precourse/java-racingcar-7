package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {

    private final List<Car> cars;

    public Racing(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> move(final int score) {
        for (Car car : cars) {
            car.go(score);
        }
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinners() {
        final int maxScore = getMaxScore();
        return cars.stream()
                .filter(car -> car.isWinner(maxScore))
                .toList();
    }

    private int getMaxScore() {
        return (int) cars.stream()
                .mapToLong(Car::getScore)
                .max()
                .orElse(0L);
    }

}
