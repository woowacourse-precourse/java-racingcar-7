package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.factory.RacingCarFactory;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = RacingCarFactory.createController();
        racingCarController.startRacing();
    }
}