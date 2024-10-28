package racingcar.domain;

import java.util.List;
import racingcar.domain.car.Car;

public class Game {
    private final List<Car> cars;
    private final int totalRounds;
    private int completedRounds = 0;

    public Game(List<Car> cars, int totalRounds) {
        this.cars = cars;
        this.totalRounds = totalRounds;
    }

    public boolean hasRemainingRounds() {
        return completedRounds < totalRounds;
    }

    public void playOneRound() {
        cars.forEach(Car::moveIfPossible);
        completedRounds++;
    }
}
