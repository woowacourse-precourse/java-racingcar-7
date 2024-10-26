package racingcar.controller;

import racingcar.view.OutputView;

public class RacingCarController {
    public void init() {
        handleInputCarNames();
    }

    public void handleInputCarNames() {
        OutputView.printCarNamesInputGuide();
    }
}
