package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.Winners;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Race race = initializeRace();
        executeRace(race);
        announceWinners(race);
    }

    private Race initializeRace() {
        String carNames = inputView.inputCarNames();
        InputValidator.validateEmpty(carNames);
        int attemptCount = parseAttemptCount();
        return Race.createRace(carNames, attemptCount);
    }

    private int parseAttemptCount() {
        String attemptInput = inputView.inputAttemptCount();
        InputValidator.validateEmpty(attemptInput);
        InputValidator.validateNumeric(attemptInput);
        return Integer.parseInt(attemptInput);
    }

    private void executeRace(Race race) {
        String racingProgress = race.displayRacingProgress();
        outputView.printExecuteResult(racingProgress);
    }

    private void announceWinners(Race race) {
        Winners winners = Winners.createWinners(race.getWinners());
        String winnerNames = winners.displayWinners();
        outputView.printFinalResult(winnerNames);
    }
}