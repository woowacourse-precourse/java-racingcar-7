package racingcar.config;

import racingcar.controller.GameController;
import racingcar.domain.Car;
import racingcar.domain.factory.CarFactory;
import racingcar.view.InputParser;
import racingcar.view.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    private final InputView inputView;
    private final InputParser inputParser;
    private final InputValidator inputValidator;
    private final OutputView outputView;
    private final GameController gameController;

    public AppConfig() {
        this.inputView = new InputView();
        this.inputParser = new InputParser();
        this.inputValidator = new InputValidator();
        this.outputView = new OutputView();
        this.gameController = new GameController(
                inputView,
                outputView
        );
    }

    public GameController getGameController() {
        return gameController;
    }
}
