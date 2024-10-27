package racingcar.controller;

import racingcar.model.AttemptCount;
import racingcar.model.RaceCars;
import racingcar.model.RacingGame;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public void startGame() {
        RacingGame racingGame = initializeRacingGame();
        playRace(racingGame);
    }

    private void playRace(final RacingGame racingGame) {
        OutputView.printExecutionResultMessage();
        while (racingGame.canRace()) {
            racingGame.race();
            OutputView.printRaceResult(racingGame.findCurrentPosition());
        }
        OutputView.printWinners(racingGame.findWinnerNames());
    }

    private RacingGame initializeRacingGame() {
        RaceCars raceCars = RaceCars.fromNames(InputView.inputCarNames());
        AttemptCount attemptCount = AttemptCount.from(InputView.inputAttemptCount());
        return new RacingGame(raceCars, attemptCount, new RandomNumberGenerator());
    }

}
