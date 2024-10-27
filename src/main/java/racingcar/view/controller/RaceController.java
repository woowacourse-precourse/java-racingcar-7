package racingcar.view.controller;

import racingcar.view.InputView;

public class RaceController {

    private final InputView inputView;

    public RaceController() {
        inputView = new InputView();
    }

    public void start() {
        String Cars = inputView.requestCarsName();
    }

}
