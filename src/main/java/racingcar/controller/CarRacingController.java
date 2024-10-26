package racingcar.controller;

import racingcar.view.OutputView;

public class CarRacingController {

    private OutputView outputView;

    public CarRacingController(){
        this.outputView = new OutputView();
    }

    public void inputValues(){
        outputView.printCarNameMessage();
    }
}
