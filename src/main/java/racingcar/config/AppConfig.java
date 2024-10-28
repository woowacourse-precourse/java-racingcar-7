package racingcar.config;

import racingcar.controller.GameController;
import racingcar.model.CarMaker;
import racingcar.model.CarMover;
import racingcar.model.RacingGame;
import racingcar.validation.CarNameValidator;
import racingcar.validation.RoundNumberValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    private static final AppConfig appConfig = new AppConfig();

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private CarMaker carMaker = new CarMaker(new CarNameValidator());
    private RacingGame racingGame = new RacingGame(new CarMover());
    private RoundNumberValidator roundNumberValidator = new RoundNumberValidator();
    private GameController gameController = new GameController(inputView, outputView, carMaker, racingGame,
            roundNumberValidator);


    public static AppConfig getAppConfig() {
        return appConfig;
    }

    public GameController gameController() {
        return gameController;
    }

    public void reset() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carMaker = new CarMaker(new CarNameValidator());
        this.racingGame = new RacingGame(new CarMover());
        this.roundNumberValidator = new RoundNumberValidator();
        this.gameController = new GameController(inputView, outputView, carMaker, racingGame, roundNumberValidator);
    }
}
