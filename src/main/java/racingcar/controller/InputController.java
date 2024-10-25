package racingcar.controller;

import racingcar.view.InputView;

public class InputController {

    private InputView inputView = new InputView();

    public InputController() {
        this.inputView = inputView;
    }

    public static void run() {
        InputView.getUserInput();

    }
}
