package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.RacingCarView;

public class Application {
    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView();
        RacingController racingController = new RacingController(racingCarView);

        racingController.run();
    }
}
