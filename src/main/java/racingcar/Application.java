package racingcar;

import racingcar.controller.RaceController;
import racingcar.controller.UIController;

public class Application {
    public static void main(String[] args) {

        RaceController raceController = new RaceController(
                new UIController()
        );

        raceController.run();
    }
}
