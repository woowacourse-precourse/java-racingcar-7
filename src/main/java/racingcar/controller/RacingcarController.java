package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.gameuserdata.RacingUserData;
import racingcar.model.FindManyMovingRacingcar;
import racingcar.model.RacingPlayingCycle;
import racingcar.model.RacingcarDataVerification;
import racingcar.splitter.RacingcarSplitter;
import racingcar.view.InputView;
import racingcar.view.OuputView;

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
