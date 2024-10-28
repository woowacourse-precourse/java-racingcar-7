package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        for (final Car car : cars) {
            car.move(NumberGenerator.getRandomNumber());
        }
    }

    public List<Car> get() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinners() {
        final List<String> winners = new ArrayList<>();
        final int maxCount = findMaxMoveCount();

        for (final Car car : cars) {
            if (car.getMoveCount() == maxCount) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int findMaxMoveCount() {
        int maxMoveCount = 0;
        for (final Car car : cars) {
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }
        return maxMoveCount;
    }
}
