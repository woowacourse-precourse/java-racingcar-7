package racingcar.config;

import racingcar.controller.GameController;
import racingcar.controller.InputController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameConfiguration {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputController inputController;
    private final GameController gameController;

    public GameConfiguration() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputController = new InputController(inputView);
        this.gameController = new GameController(inputController, outputView);
    }

    public GameController getGameController() {
        return gameController;
    }
}