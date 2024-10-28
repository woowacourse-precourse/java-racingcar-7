package racingcar.controller;

import java.util.List;
import racingcar.gameuserdata.RacingUserData;
import racingcar.model.RacingcarDataVerification;
import racingcar.splitter.RacingcarSplitter;
import racingcar.view.InputView;

public class RacingcarController {
    private final InputView inputView;
    private final RacingcarDataVerification racingcarDataVerification;
    private final RacingcarSplitter splitter;

    public RacingcarController() {
        inputView = new InputView();
        racingcarDataVerification = new RacingcarDataVerification();
        splitter = new RacingcarSplitter();
    }

    public void run() {
        String RacingCarNames = inputView.getRacingCarInput();
        int RacingCount = inputView.getRaingCountInput();

        String[] RacingCarSplitName = RacingCarNames.split(",");
        racingcarDataVerification.validateRacingCarNames(RacingCarSplitName);
        List<RacingUserData> racingUserDataList = splitter.racingUserDataSplitter(RacingCarSplitName);
    }
}
