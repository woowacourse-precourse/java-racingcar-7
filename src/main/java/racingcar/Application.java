package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;

public class Application {

    public static void main(String[] args) {
        RacingGameService racingGameService = new RacingGameService();
        RacingGameController racingGameController = new RacingGameController(racingGameService);
        racingGameController.run();
    }
}
