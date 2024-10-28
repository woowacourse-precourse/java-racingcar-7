package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.Cars;
import racingcar.view.RaceView;
import racingcar.view.SystemView;

public class Application {
    public static void main(String[] args) {
        SystemView systemView = new SystemView();
        RaceView raceView = new RaceView();
        Cars cars = new Cars();
        RacingGameController controller = new RacingGameController(systemView, raceView, cars);
        controller.run();
    }
}
