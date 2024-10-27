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
        String carNames = inputView.getCarNames();
        inputValidator.validateInputCarNames(carNames);
        return carNames;
    }

    public int inputAttemptCount() {
        String attemptCount = inputView.getAttemptCount();
        inputValidator.validateInputAttemptCount(attemptCount);
        return Integer.parseInt(attemptCount);
    }
}
