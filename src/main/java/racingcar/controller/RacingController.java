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
    private InputView inputView;
    private OutputView outputView;

    public RacingController(RacingInputValidateService racingInputValidateService,
                            MoveForwardService moveForwardService,
                            WinnerService winnerService,
                            InputView inputView, OutputView outputView) {
        this.racingInputValidateService = racingInputValidateService;
        this.moveForwardService = moveForwardService;
        this.winnerService = winnerService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String carName = inputView.getCarName();
        List<String> splittedCarNames = getSplittedCarNames(carName);
        racingInputValidateService.validateCarName(splittedCarNames);

        String tryCounts = inputView.getTryCounts();
        racingInputValidateService.validateTryCount(tryCounts);
        go(splittedCarNames, tryCounts);
        printWinner();
    }

    private List<String> getSplittedCarNames(String input) {
        return racingInputValidateService.splitCarName(input);
    }

    private void go(List<String> input, String tryCounts) {
        moveForwardService.setMoveForwardRecord(input);
        List<MoveForwardRecord> moveForwardRecords = moveForwardService.getMoveForwardRecords();
        outputView.go(tryCounts, moveForwardRecords);
    }

    private void printWinner() {
        List<MoveForwardRecord> moveForwardRecords = moveForwardService.getMoveForwardRecords();
        winnerService.countSortReverse(moveForwardRecords);
        List<String> winners = winnerService.getWinners(moveForwardRecords);
        outputView.printWinner(winners);
    }
}