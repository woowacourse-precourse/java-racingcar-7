package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.service.RacingService;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingService = new RacingService();
    }

    public void run() {
        initializeCars();
        int count = insertTryCount();
        startRace(count);
        displayWinners();
    }

    private void startRace(int count) {
        outputView.printRacingResult();
        race(count);
    }

    private void displayWinners() {
        outputView.printWinners(racingService.findWinners());
    }

    private void race(int count) {
        for (int i = 0; i < count; i++) {
            racingService.moveCars();
            outputView.printCarDistances(racingService.fetchCarNames(), racingService.fetchCarsPositions());
        }
    }

    private void initializeCars() {
        String input = inputView.promptForCarNames();
        racingService.initializeCars(input);
    }

    private int insertTryCount() {
        String attemptCountInput = inputView.promptForAttemptCount();
        return racingService.insertTryCount(attemptCountInput);
    }

}