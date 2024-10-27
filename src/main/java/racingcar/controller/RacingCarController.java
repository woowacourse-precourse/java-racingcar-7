package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private InputView inputView;
    private OutputView outputView;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void game() {
        String racingCarNames = inputView.getRacingCarNames();
        String totalAttempts = inputView.getTotalAttempts();
    }
}
