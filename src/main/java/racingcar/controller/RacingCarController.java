package racingcar.controller;

import java.util.Set;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView;

    public RacingCarController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        inputView.printCarNameInputMessage();
        Set<String> carNames = InputValidator.validateCarNameInput(inputView.getCarName());
    }
}
