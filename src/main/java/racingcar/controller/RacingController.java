package racingcar.controller;

import racingcar.model.Racing;
import racingcar.view.InputView;

public class RacingController {

    private InputView inputView;

    public RacingController() {
        inputView = new InputView();
    }

    public void run() {
        inputView.printInputView();

        Racing racing = new Racing();
    }
}
