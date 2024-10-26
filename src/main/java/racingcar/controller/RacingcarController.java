package racingcar.controller;

import racingcar.view.InputView;

public class RacingcarController {

    private final InputView inputView;

    public RacingcarController() {
        this.inputView = new InputView();
    }

    public String getCarNames() {
        inputView.printGetCarNamesMessage();
        inputView.getInput();
        return "success";
    }

    public String getAttemptCount() {
        inputView.printGetAttemptCountMessage();
        inputView.getInput();
        return "success";
    }
}
