package racingcar.controller;

import racingcar.commander.MovementCommander;
import racingcar.domain.Cars;

public class RacingController {

    private final MovementCommander movementCommander;

    public RacingController(MovementCommander movementCommander) {
        this.movementCommander = movementCommander;
    }

    public Cars createCars(String names) {
        return Cars.from(names);
    }

    public Cars rap(Cars cars) {
        return cars.move(movementCommander);
    }
}
