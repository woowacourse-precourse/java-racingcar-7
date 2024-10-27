package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void startGame() {
        String carNames = getCarNames();
    }

    private static String getCarNames() {
        OutputView.showCarNameInputMessage();
        return InputView.inputCarNames();
    }
}
