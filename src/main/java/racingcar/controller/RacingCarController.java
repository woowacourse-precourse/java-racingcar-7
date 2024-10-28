package racingcar.controller;

import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView = new InputView();

    public void run() {
        String carNames;

        inputView.displayCarNamesPrompt();
        carNames = inputView.inputCarNames();
    }
}
