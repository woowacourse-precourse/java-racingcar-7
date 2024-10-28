package racingcar;

import racingcar.Controller.RacingGameController;
import racingcar.Service.RacingGameService;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingGameService gameService = new RacingGameService();

        RacingGameController controller = new RacingGameController(
            outputView,
            inputView,
            gameService
        );

        controller.run();
    }
}
