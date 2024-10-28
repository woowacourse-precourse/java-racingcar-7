package racingcar.controller;

import racingcar.model.Cars;
import racingcar.util.NumberParser;
import racingcar.view.RacingCarGameInputView;

public class RacingGameController {

    public void run() {
        Cars cars = new Cars(RacingCarGameInputView.inputCarNames());
        int totalRounds = NumberParser.parsePositiveInteger(RacingCarGameInputView.inputTotalRound());
    }
}
