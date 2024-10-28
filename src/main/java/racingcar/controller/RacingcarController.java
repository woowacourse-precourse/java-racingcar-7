package racingcar.controller;

import racingcar.view.InputView;

public class RacingcarController {
    private final InputView inputView;

    public RacingcarController() {
        inputView = new InputView();
    }

    public void run() {
        String RacingCarNames = inputView.getRacingCarInput();
        int RacingCount = inputView.getRaingCountInput();

        String[] RacingCarSplitName = RacingCarNames.split(",");
    }
}
