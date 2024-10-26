package racingcar.controller;

import racingcar.view.InputView;

public class RacingCarController {

    public RacingCarController() {
    }

    public void run() {
        String inputCarNames = InputView.enterCarNames();
        int inputNumberOfAttempts = InputView.enterNumberOfAttempts();
    }
}
