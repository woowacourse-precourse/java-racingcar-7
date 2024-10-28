package racingcar.config;

import racingcar.controller.GameController;
import racingcar.controller.InputController;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameConfiguration {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputController inputController;
    private final GameService gameService;
    private final GameController gameController;

    public GameConfiguration() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputController = new InputController(inputView);
        this.gameService = new GameService();
        this.gameController = new GameController(
                inputController,
                outputView,
                gameService
        );
    }

    public GameController getGameController() {
        return gameController;
    }
}