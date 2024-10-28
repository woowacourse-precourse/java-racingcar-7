package racingcar.controller;

import java.util.List;
import racingcar.domain.MoveForwardRecord;
import racingcar.service.MoveForwardService;
import racingcar.service.RacingInputValidateService;
import racingcar.service.WinnerService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private RacingInputValidateService racingInputValidateService;
    private MoveForwardService moveForwardService;
    private WinnerService winnerService;

    public RacingController(RacingInputValidateService racingInputValidateService,
                            MoveForwardService moveForwardService,
                            WinnerService winnerService) {
        this.racingInputValidateService = racingInputValidateService;
        this.moveForwardService = moveForwardService;
        this.winnerService = winnerService;
    }

    public void run() {
        List<String> carNames = getCarName();
        String tryCounts = getTryingCount();

        go(carNames, tryCounts);
        printWinner();
    }

    private String getTryingCount() {
        String tryCounts = InputView.getTryCounts();
        racingInputValidateService.validateTryCount(tryCounts);

        return tryCounts;
    }

    private List<String> getCarName() {
        String carName = InputView.getCarName();
        List<String> splittedCarNames = racingInputValidateService.splitCarName(carName);
        racingInputValidateService.validateCarName(splittedCarNames);

        return splittedCarNames;
    }

    private void go(List<String> input, String tryCounts) {
        moveForwardService.setMoveForwardRecord(input);
        moveForwardService.printMovingForwardProcess(tryCounts);
    }

    private void printWinner() {
        List<MoveForwardRecord> moveForwardRecords = moveForwardService.getMoveForwardRecords();

        winnerService.countSortReverse(moveForwardRecords);

        List<String> winners = winnerService.getWinners(moveForwardRecords);
        OutputView.printWinner(winners);
    }
}