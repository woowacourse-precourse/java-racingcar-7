package racingcar;

import racingcar.controller.RacingController;
import racingcar.controller.service.RacingControllerFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingController racingController = RacingControllerFactory.crate();
        racingController.run();
    }
}