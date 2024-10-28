package racingcar.controller;

import racingcar.model.RacingcarDataVerification;
import racingcar.view.InputView;

public class RacingcarController {
    private final InputView inputView;
    private final RacingcarDataVerification racingcarDataVerification;

    public RacingcarController() {
        inputView = new InputView();
        racingcarDataVerification = new RacingcarDataVerification();
    }

    public void run() {
        String RacingCarNames = inputView.getRacingCarInput();
        int RacingCount = inputView.getRaingCountInput();

        String[] RacingCarSplitName = RacingCarNames.split(",");
        racingcarDataVerification.validateRacingCarNames(RacingCarSplitName);
    }
}
