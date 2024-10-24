package racingcar;

import racingcar.controller.RaceController;
import racingcar.controller.UIController;
import racingcar.service.RaceService;

public class Application {
    public static void main(String[] args) {

        RaceController raceController = new RaceController(
                new UIController(),
                new RaceService()
        );

        raceController.run();
    }
}
