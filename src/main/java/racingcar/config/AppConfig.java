package racingcar.config;

import racingcar.controller.GameController;
import racingcar.model.CarMaker;
import racingcar.model.CarMover;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public GameController gameController() {
        return new GameController(
                new InputView(), new OutputView(), new CarMaker(), racingGame());
    }

    public RacingGame racingGame() {
        return new RacingGame(new CarMover());
    }
}
