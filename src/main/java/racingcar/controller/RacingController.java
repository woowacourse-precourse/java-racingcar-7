package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        inputCarNames();
    }

    private void inputCarNames() {
        outputView.printInputCarNames();
        String carNames = inputView.inputCarNames();
    }
}
