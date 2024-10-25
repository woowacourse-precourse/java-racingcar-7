package racingcar.controller;

import java.util.List;
import racingcar.service.RacingService;
import racingcar.view.InputView;

public class RacingController {

    private RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    public void run() {
        String carName = InputView.getCarName();
        List<String> splittedCarNames = getSplittedCarNames(carName);
        racingService.validateCarName(splittedCarNames);

        String tryCounts = InputView.getTryCounts();
        racingService.validateTryCount(tryCounts);
        go(splittedCarNames, tryCounts);
        printWinner();
    }

    public List<String> getSplittedCarNames(String input) {
        return racingService.splitCarName(input);
    }

    public void go(List<String> input, String tryCounts) {
        racingService.setMoveForwardRecord(input);
        racingService.go(tryCounts);
    }

    public void printWinner() {
        racingService.printWinner();
    }
}
