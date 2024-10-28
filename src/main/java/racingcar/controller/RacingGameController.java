package racingcar.controller;

import racingcar.domain.CarList;
import racingcar.views.InputView;

public class RacingGameController {

    public void run() {
        String input = InputView.inputString();
        CarList carList = new CarList(input);
    }
}
