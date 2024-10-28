package racingcar.controller;

import racingcar.view.InputView;

public class RacingController {

    InputView inputView = new InputView();

    public void runRace() {
        String carInput = getCarInput();
        int countInput = getCountInput();
    }

    private int getCountInput() {
        inputView.printCountInput();
        return inputView.getIntegerInput();
    }

    private String getCarInput() {
        inputView.printCarInput();
        return inputView.getStringInput();
    }

}
