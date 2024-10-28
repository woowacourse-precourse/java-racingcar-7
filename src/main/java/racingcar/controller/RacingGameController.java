package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.RacingCarGameInputView;

public class RacingGameController {

    public void run() {
        Cars cars = new Cars(RacingCarGameInputView.inputCarNames());
    }
}
