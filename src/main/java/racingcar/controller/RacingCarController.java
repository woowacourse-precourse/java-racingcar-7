package racingcar.controller;

import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView = new InputView();

    public void run() {
        String carNames;
        int tryCount;

        inputView.displayCarNamesPrompt();
        carNames = inputView.inputCarNames();
        inputView.displayTryCountPrompt();
        tryCount = inputView.inputTryCount();
    }
}
