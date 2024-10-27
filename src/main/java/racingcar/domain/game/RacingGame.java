package racingcar.domain.game;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int tryRounds;
    MovementChecker movementChecker = new MovementChecker();

    public RacingGame(List<String> carNames, int tryRounds) {
        this.cars = new Cars(carNames);
        this.tryRounds = tryRounds;
    }

    public void run() {
        for (int i = 0; i < tryRounds; i++) {
            executeCarsAction();
        }
    }

    private void executeCarsAction() {
        for (Car car : cars.getCars()) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        boolean isMovable = movementChecker.isMovable();
        if (isMovable) {
            car.move();
        }
    }
}
