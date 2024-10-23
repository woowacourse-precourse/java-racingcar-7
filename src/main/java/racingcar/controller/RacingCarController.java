package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final OutputView outputView;
    private final InputView inputView;

    public RacingCarController() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void start() {
        String readCarNames = getCarNames();
        String readNumberOfAttempts = getNumberOfAttempts();
        RacingCarService racingCarService = new RacingCarService(readCarNames, readNumberOfAttempts);
        outputView.printResultMessage();
        racingCarService.play(outputView);
        printResult(racingCarService);
    }

    private void printResult(RacingCarService racingCarService) {
        String winners = racingCarService.getWinners();
        outputView.printWinners(winners);
    }

    private String getNumberOfAttempts() {
        outputView.printReadNumberOfAttempts();
        return inputView.readNumberOfAttempts();
    }

    private String getCarNames() {
        outputView.printReadCarNameMessage();
        return inputView.readCarNames();
    }
}
