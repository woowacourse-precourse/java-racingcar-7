package racingcar.controller;

import racingcar.view.InputView;

public class Controller {
    private final InputView inputView;

    public Controller(final InputView inputView) {
        this.inputView = inputView;
    }

    public String inputCarNames() {
        return inputView.getCarNames();
    }

    public int inputAttemptCount() {
        return inputView.getAttemptCount();
    }
}
