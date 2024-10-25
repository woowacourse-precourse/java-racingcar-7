package racingcar.config;

import racingcar.controller.GameController;
import racingcar.model.CarMaker;
import racingcar.model.CarMover;
import racingcar.model.CarNameValidator;
import racingcar.model.RacingGame;
import racingcar.model.RoundNumberValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public GameController gameController() {
        return new GameController(
                new InputView(), new OutputView(), carMaker()
                , racingGame(), new RoundNumberValidator());
    }

    public RacingGame racingGame() {
        return new RacingGame(new CarMover());
    }

    public CarMaker carMaker() {
        return new CarMaker(new CarNameValidator());
    }
}
