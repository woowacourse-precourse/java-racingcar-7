package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCar {
    public void run(){
        OutputView.printCarNamesPrompt();
        InputView inputView = new InputView();
        String car = inputView.userInput();


    }
}
