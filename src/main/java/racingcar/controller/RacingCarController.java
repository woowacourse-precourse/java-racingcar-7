package racingcar.controller;

import racingcar.view.InputView;

public class RacingCarController {

    private final InputView inputView;

    public RacingCarController() {
        this.inputView = new InputView();
    }

    public void run() {
        inputView.printInputCarNameMessage();
        String carNames = inputView.getInput();

        inputView.printInputTryCountMessage();
        String tryCount = inputView.getInput();
        System.out.println(tryCount);
    }
}
