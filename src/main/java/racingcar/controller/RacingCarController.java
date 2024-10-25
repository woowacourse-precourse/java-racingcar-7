package racingcar.controller;

import racingcar.view.InputView;

public class RacingCarController {

    private final InputView inputView;

    public RacingCarController() {
        this.inputView = new InputView();
    }

    public void start() {
        String inputCarNames = inputView.inputCarNames();
        
    }

}
