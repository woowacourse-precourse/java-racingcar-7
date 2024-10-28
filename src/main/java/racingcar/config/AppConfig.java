package racingcar.config;

import racingcar.controller.GameController;
import racingcar.model.car.CarFactory;
import racingcar.model.movementstrategy.MovementStrategy;
import racingcar.model.movementstrategy.RandomMovementStrategy;
import racingcar.model.service.RacingCarService;

public class AppConfig {
    public GameController gameController() {
        return new GameController(racingCarService());
    }

    public RacingCarService racingCarService() {
        return new RacingCarService(carFactory());
    }

    public CarFactory carFactory() {
        return new CarFactory(movement());
    }

    public MovementStrategy movement() {
        return new RandomMovementStrategy();
    }
}
