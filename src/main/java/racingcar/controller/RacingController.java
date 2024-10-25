package racingcar.controller;

import racingcar.domain.Race;
import racingcar.domain.Winners;
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
        String carNames = inputView.inputCarNames();
        int attemptCount = Integer.parseInt(inputView.inputAttemptCount());

        Race race = Race.createRace(carNames, attemptCount);
        outputView.printExecuteResult(race.displayRacingProgress());

        Winners winners = Winners.createWinners(race.getWinners());
        outputView.printFinalResult(winners.displayWinners());
    }
}
