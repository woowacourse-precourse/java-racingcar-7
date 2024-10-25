package racingcar.controller;

import java.util.List;
import racingcar.view.Input;
import racingcar.view.Output;

public class CarRacingController {

    private Input input;
    private Output output;

    public CarRacingController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void startCarRacing() {
        List<String> carNames = input.inputCarNames();
        int roundCount = input.inputRoundCount();

    }
}
