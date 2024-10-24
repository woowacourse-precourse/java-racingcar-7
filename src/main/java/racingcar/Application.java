package racingcar;

import racingcar.controller.RaceController;
import racingcar.domain.car.MovingStrategy;
import racingcar.domain.car.RandomMovingStrategy;

public class Application {

    public static void main(String[] args) {
        MovingStrategy movingStrategy = new RandomMovingStrategy();

        RaceController raceController = new RaceController(movingStrategy);

        raceController.run();
    }
}