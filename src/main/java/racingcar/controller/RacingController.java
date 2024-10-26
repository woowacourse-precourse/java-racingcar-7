package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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
        racingService.race(count);
        endRace();
    }

    private void endRace() {
        outputView.printRacingResult();
        outputView.printWinners(racingService.findWinners());
        outputView.printCarDistances(racingService.fetchCarNames(), racingService.fetchCarsPositions());
    }

    private void initializeCars() {
        String input = inputView.promptForCarNames();
        racingService.initializeCars(input);
    }

    private int insertTryCount() {
        String attemptCountInput = inputView.promptForAttemptCount();
        return racingService.insertTryCount(attemptCountInput); // int형으로 반환
    }



}
