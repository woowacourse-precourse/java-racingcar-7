package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingController racingController = new RacingController(new RacingService());
        racingController.run();
    }
}
