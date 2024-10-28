package racingcar.service;

import racingcar.domain.Cars;
import racingcar.util.MovementStrategy;

public class GameService {
    private final MovementStrategy movementStrategy;

    public GameService() {
        this.movementStrategy = new MovementStrategy();
    }

    public void playRound(Cars cars) {
        cars.moveAll(movementStrategy);
    }
}