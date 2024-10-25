package racingcar.controller;

import racingcar.domain.Input;
import racingcar.view.InputView;

public class InputController {

    private static Input input;
    private static InputView inputView = new InputView();

    public InputController() {
        this.input = input;
        this.inputView = inputView;
    }

    public static void run() {
        inputView.getStringInput();
        inputView.getCountInput();
    }
}
