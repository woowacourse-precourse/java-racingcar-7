package racingcar.controller;

import racingcar.validate.InputValidator;
import racingcar.view.InputView;

public class InputController {
    private final InputView inputView;
    private final InputValidator inputValidator;

    public InputController(InputView inputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
    }

    public String inputCarNames() {
        return inputView.getCarNames();
    }

    public int inputAttemptCount() {
        String attemptCount = inputView.getAttemptCount();
        return Integer.parseInt(attemptCount);
    }
}
