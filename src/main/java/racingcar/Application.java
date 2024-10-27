package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.parser.AttemptParser;
import racingcar.parser.CarNameParser;
import racingcar.service.MoveService;
import racingcar.service.RacingGameService;
import racingcar.service.WinnerService;
import racingcar.validator.AttemptValidator;
import racingcar.validator.CarNameValidator;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(
                new CarNameParser(), new CarNameValidator(),
                new AttemptParser(), new AttemptValidator(),
                new RacingGameService(new MoveService(), new WinnerService()));

        racingGameController.run();
    }
}
