package racingcar.config;

import racingcar.controller.DefaultGameInputValidator;
import racingcar.controller.GameController;

public class GameControllerFactory {
    public static GameController create() {
        return new GameController(DefaultGameInputValidator.getInstance());
    }
}
