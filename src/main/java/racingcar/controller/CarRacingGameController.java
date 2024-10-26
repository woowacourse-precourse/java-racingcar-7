package racingcar.controller;

import racingcar.dto.CarNameRequest;
import racingcar.dto.TryNumberRequest;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingGameController {

    public void start() {
        OutputView.printSetCarNameMessage();
        CarNameRequest carNameList = InputView.getCarName();

        OutputView.printSetTryNumberMessage();
        TryNumberRequest tryNumber = InputView.getTryNumber();
    }

}
