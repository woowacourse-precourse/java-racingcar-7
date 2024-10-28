package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.Cars;
import racingcar.strategy.MovementStrategy;
import racingcar.strategy.RandomMovementStrategy;
import racingcar.view.RaceView;
import racingcar.view.SystemView;

public class Application {
    public static void main(String[] args) {
        SystemView systemView = new SystemView();
        RaceView raceView = new RaceView();
        MovementStrategy strategy = new RandomMovementStrategy();
        Cars cars = new Cars(strategy);
        cars.registerObserver(raceView);
        RacingGameController controller = new RacingGameController(systemView, raceView, cars);
        controller.run();
    }
}
