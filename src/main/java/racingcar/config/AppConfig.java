package racingcar.config;

import racingcar.controller.GameController;
import racingcar.model.car.CarFactory;
import racingcar.model.movement.Movement;
import racingcar.model.movement.RandomMovement;
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

    public Movement movement() {
        return new RandomMovement();
    }
}
