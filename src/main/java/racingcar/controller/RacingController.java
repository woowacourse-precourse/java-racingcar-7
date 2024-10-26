package racingcar.controller;

import racingcar.model.Racing;
import racingcar.view.InputView;

public class RacingController {

    public RacingController() {
    }

    public void run() {
        InputView inputView = new InputView();
        inputView.printInputView();

        Racing racing = new Racing();
    }
}
