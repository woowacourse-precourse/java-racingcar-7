package racingcar;

import racingcar.controller.GameController;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        GameService gameService = new GameService();
        OutputView outputView = new OutputView();

        GameController gameController = new GameController(inputView, gameService, outputView);
        gameController.run();
    }
}
