package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    public void run() {
        OutputView.requestCarNames();
        String inputCarNames = InputView.getCarNames();
    }
}
