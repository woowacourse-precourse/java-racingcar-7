package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingGameController {

    public void start() {
        OutputView.printSetCarNameMessage();
        String carNames = InputView.getCarName();
    }

}
