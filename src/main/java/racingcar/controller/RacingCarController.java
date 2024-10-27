/*
 * RacingCarController
 *
 * ver1
 *
 * 2024-10-24
 *
 * 저작권 주의
 */
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
        RacingCarService racingCarService = getRacingCarService();
        play(racingCarService);
        printResult(racingCarService);
    }

    private RacingCarService getRacingCarService() {
        String readCarNames = getCarNames();
        String readNumberOfAttempts = getNumberOfAttempts();
        return new RacingCarService(readCarNames, readNumberOfAttempts);
    }

    private void play(RacingCarService racingCarService) {
        outputView.printResultMessage();
        racingCarService.play(outputView);
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
