package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final OutputView outputView;
    private final InputView inputView;

    public RacingCarController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        String rawNames = receiveCarNames();
    }

    private String receiveCarNames() {
        outputView.requestCarNames();
        return inputView.receiveCarNames();
    }
}
