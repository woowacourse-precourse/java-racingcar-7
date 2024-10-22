package racingcar.controller;

import racingcar.view.InputView;

public class CarController {

    private final InputView inputView;

    public CarController(){
        this.inputView = new InputView();
    }

    public void run(){
        String inputCarName = inputView.inputCarName();
    }
}
