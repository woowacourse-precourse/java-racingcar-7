package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameControllerFactory {
    public static GameController create() {
        return new GameController(InputView.getInstance(), OutputView.getInstance());
    }
}
