package racingcar.model;

import racingcar.utils.RandomNumberGenerator;

import java.util.List;

public class RacingGame {
    private static final int MOVE_THRESHOLD = 4;
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void playRound() {
        for (Car car : cars) {
            int randomValue = RandomNumberGenerator.generate();
            if (randomValue >= MOVE_THRESHOLD) {
                car.move();
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}