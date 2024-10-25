package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        List<String> names = readNames();
    }

    private List<String> readNames() {
        outputView.printCarNameMessage();
        return inputView.readCarNames();
    }
}
