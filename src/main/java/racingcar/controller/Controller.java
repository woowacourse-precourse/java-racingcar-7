package racingcar.controller;

import racingcar.view.InputView;

public class Controller {
    InputView inputView = new InputView();

    public void run() {
        String names = inputView.input();
    }
}
