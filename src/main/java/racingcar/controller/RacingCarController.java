package racingcar.controller;

import java.util.List;
import racingcar.util.InputParser;
import racingcar.view.InputView;

public class RacingCarController {
    public static void start() {
        String nameString = InputView.getCarNames();
        List<String> carNames = InputParser.nameParse(nameString);

        String numberString = InputView.getTryNumber();
        int tryNumber = InputParser.tryNumberParse(numberString);
    }

}
