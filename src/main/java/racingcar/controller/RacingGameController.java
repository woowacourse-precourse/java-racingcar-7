package racingcar.controller;

import racingcar.service.RacingGameService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final RacingGameService racingGameService;
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;

    public RacingGameController(
            RacingGameService racingGameService,
            InputView inputView,
            OutputView outputView,
            InputValidator inputValidator) {
        this.racingGameService = racingGameService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
    }
    public void run() {
        outputView.displayCarNameInput();
        String inputValue = inputView.inputCarNames();

        inputValidator.validateIsEmpty(inputValue);
    }


}
