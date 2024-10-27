package racingcar.common.factory;

import racingcar.controller.GameController;
import racingcar.model.service.CarRacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * configuration
 */
public class GameFactory {

    public GameController gameController() {
        return new GameController(carRacingGame(), inputView(), outputView());
    }

    public CarRacingGame carRacingGame() {
        return new CarRacingGame();
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}
