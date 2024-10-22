package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    public void run() {
        OutputView.printInputCarNameMessage();
        String input = InputView.inputCarNames();
        String trimmedInput = InputView.removeSpace(input);
        List<String> carNames = InputView.splitStringByDelimiters(trimmedInput, ",");

    }
}
