package racingcar.controller;

import racingcar.view.InputView;
import java.util.List;

public class GameController {

    public void runGame() {
        List<String> carNames = InputView.inputNames();
        int attemptCount = InputView.inputGameCnt();
    }
}
