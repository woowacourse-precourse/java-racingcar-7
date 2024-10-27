package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.InputService;
import racingcar.service.RacingGameService;

public class Application {
    public static void main(String[] args) {
        RacingGameService racingGameService = new RacingGameService();
        InputService inputService = new InputService();

        RacingGameController racingGameController = new RacingGameController(racingGameService,inputService);
        racingGameController.run();
    }
}
