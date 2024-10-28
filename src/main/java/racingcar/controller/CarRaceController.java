package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceController {
    private InputView inputView;
    private OutputView outputView;

    public CarRaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }
}
