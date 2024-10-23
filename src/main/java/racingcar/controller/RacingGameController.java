package racingcar.controller;

import racingcar.common.InputValidator;
import racingcar.util.Separator;
import racingcar.view.InputView;

public class RacingGameController {

    private final InputView inputView;
    private final InputValidator inputValidator;
    private final Separator separator;

    public RacingGameController(InputView inputView, InputValidator inputValidator, Separator separator) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
        this.separator = separator;
    }

    public void run() {
        gameSetting();
    }

    private void gameSetting() {
        String[] carNames = separator.splitWithComma(inputView.getCarNames());
        inputValidator.validateCarNames(carNames);

        int attemptCount = inputValidator.validateAttemptCount(inputView.getGameAttempt());

    }

}
