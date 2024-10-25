package racingcar.controller;

import racingcar.model.RaceCars;
import racingcar.view.InputView;

import java.util.List;

public class RacingGameController {

    public void startGame() {
        List<String> carNames = InputView.inputCarNames();
        int attemptCount = InputView.inputAttemptCount();
        RaceCars raceCars = new RaceCars(carNames);
    }

}
