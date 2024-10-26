package racingcar.controller;

import racingcar.dto.CarNameRequest;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingGameController {

    public void start() {
        OutputView.printSetCarNameMessage();
        CarNameRequest carNameList = InputView.getCarName();
    }

}
