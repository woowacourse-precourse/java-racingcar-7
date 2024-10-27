package racingcar;

import racingcar.common.InputValidator;
import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.vo.CarFactory;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(
                new InputValidator(),
                new CarFactory(),
                new RacingGameService()
        );

        racingGameController.run();

    }
}
