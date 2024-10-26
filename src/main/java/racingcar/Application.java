package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.factory.ControllerFactory;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = ControllerFactory.createController();
        racingCarController.run();
    }
}
