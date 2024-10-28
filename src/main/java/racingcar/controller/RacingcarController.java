package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.gameuserdata.RacingUserData;
import racingcar.model.FindManyMovingRacingcar;
import racingcar.model.RacingPlayingCycle;
import racingcar.model.RacingcarDataVerification;
import racingcar.splitter.RacingcarSplitter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final FindManyMovingRacingcar findManyMovingRacingcar;
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingcarDataVerification racingcarDataVerification;
    private final RacingPlayingCycle racingPlayingCycle;
    private final RacingcarSplitter splitter;

    public RacingcarController() {
        findManyMovingRacingcar = new FindManyMovingRacingcar();
        inputView = new InputView();
        outputView = new OutputView();
        racingcarDataVerification = new RacingcarDataVerification();
        racingPlayingCycle = new RacingPlayingCycle();
        splitter = new RacingcarSplitter();
    }

    public void run() {
        String RacingCarNames = inputView.getRacingCarInput();
        int RacingCount = inputView.getRaingCountInput();

        String[] RacingCarSplitName = RacingCarNames.split(",");
        racingcarDataVerification.validateRacingCarNames(RacingCarSplitName);
        List<RacingUserData> racingUserDataList = splitter.racingUserDataSplitter(RacingCarSplitName);

        racingUserDataList = racingPlayingCycle.racingPlayingCycle(RacingCount, racingUserDataList);

        int ManyMoveValue = findManyMovingRacingcar.FindManyMovingLength(racingUserDataList);
        ArrayList<String> RacingWinnerUsers = findManyMovingRacingcar.FindManyMovingCars(racingUserDataList,
                ManyMoveValue);

        outputView.printResult(String.join(", ", RacingWinnerUsers));
    }
}
