package racingcar;

import static racingcar.util.Message.WINNER_MESSAGE;

import racingcar.controller.InputController;
import racingcar.controller.RacingCarController;
import racingcar.service.RacingGameService;

public class Application {
    public static void main(String[] args) {
        InputController inputController = new InputController();
        RacingGameService racingGameService = new RacingGameService();
        RacingCarController racingCarController = new RacingCarController(inputController, racingGameService);

        racingCarController.run();
    }
}
