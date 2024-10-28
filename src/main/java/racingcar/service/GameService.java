package racingcar.service;

import racingcar.domain.Cars;
import racingcar.util.MovementStrategy;
import racingcar.util.RandomMovementStrategy;

public class GameService {
    private final MovementStrategy movementStrategy;

    public GameService() {
        this.movementStrategy = new RandomMovementStrategy();
    }


    public void playRound(Cars cars) {
        cars.moveAll(movementStrategy);
    }
}