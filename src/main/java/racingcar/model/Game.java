package racingcar.model;

import java.util.List;

import static racingcar.view.OutputView.printGameStatus;

public class Game {
    private final List<Car> cars;
    private final int attemptCount;

    public Game(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void start() {
        for (int i = 0; i < attemptCount; i++) {
            moveCars();
            printGameStatus(cars);
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }
}
