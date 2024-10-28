package racingcar.config;

import racingcar.controller.GameController;
import racingcar.domain.RacingGame;
import racingcar.view.InputParser;
import racingcar.view.InputValidator;
import racingcar.view.InputView;

public class AppConfig {
    private final InputView inputView;
    private final InputParser inputParser;
    private final InputValidator inputValidator;
    private final RacingGame racingGame;
    private final GameController gameController;

    public AppConfig() {
        this.inputView = new InputView();
        this.inputParser = new InputParser();
        this.inputValidator = new InputValidator();
        this.racingGame = new RacingGame();
        this.gameController = new GameController(
                inputView
        );
    }

    public GameController getGameController() {
        return gameController;
    }
}
