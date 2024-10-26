package racingcar.controller;

import racingcar.view.OutputView;

public class RacingCarController {
    public void init() {
        handleInputCarNames();
        handleInputMoveCount();
    }

    public void handleInputCarNames() {
        OutputView.printCarNamesInputGuide();
    }

    public void handleInputMoveCount() {
        OutputView.printMoveCountInputGuide();
    }
}
