package racingcar.config;

import racingcar.controller.DefaultGameInputValidator;
import racingcar.controller.GameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameControllerFactory {
    public static GameController create() {
        return new GameController(InputView.getInstance(), OutputView.getInstance(),
                DefaultGameInputValidator.getInstance());
    }
}
