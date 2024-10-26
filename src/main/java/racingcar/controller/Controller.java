package racingcar.controller;

import racingcar.view.InputView;

public class Controller {

    private final InputView inputView = new InputView();

    public void run() {
        String inputCarList = inputView.inputCarList();
    }
}
