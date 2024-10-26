package racingcar.controller;

import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = new InputValidator();
    }

    public void run() {
        String[] carNames = getCarNames();
        String trialCountInput = getTrialCount();

        validateInput(trialCountInput);
        inputView.close();

        int trialCount = Integer.parseInt(trialCountInput);
    }

    private String[] getCarNames() {
        outputView.printCarNameInputMessage();
        String carNamesInput = inputView.readLine();
        return splitCarNames(carNamesInput);
    }

    private String[] splitCarNames(String input) {
        return input.split(",");
    }

    private String getTrialCount() {
        outputView.printTrialCountInputMessage();
        return inputView.readLine();
    }

    private void validateInput(String trialCountInput) {
        inputValidator.validateTrialCount(trialCountInput);
        inputValidator.validateTrialCount(trialCountInput);
    }
}

