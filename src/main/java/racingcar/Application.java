package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import service.PlayerService;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        PlayerService playerService = new PlayerService();

        RacingGameController racingGameController = new RacingGameController(inputView, outputView, playerService);
        racingGameController.run();
    }
}
