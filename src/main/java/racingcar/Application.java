package racingcar;

import racingcar.controller.RacingController;
import racingcar.controller.RacingControllerFactory;

public class Application {

    public static void main(String[] args) {
        RacingController racingController = RacingControllerFactory.create();
        racingController.start();
    }
}
