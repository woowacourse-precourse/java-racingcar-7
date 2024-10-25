package racingcar.racingGame;

import racingcar.domain.*;
import racingcar.views.InputView;
import racingcar.views.OutputView;

import java.math.BigInteger;
import java.util.List;

public class RacingGame extends RacingGameTemplate {

    private RaceManager raceManager;

    public RacingGame() {
    }

    @Override
    protected void initializeGame() {
        raceManager = RaceManager.createRaceManager(
                RacingCars.from(InputView.inputCarNames()),
                Attempts.from(InputView.inputRaceAttempts())
        );
    }

    @Override
    protected void race() {
        raceManager.racePerAttempt();
    }

    @Override
    protected void announceWinners() {
        BigInteger winningPosition = raceManager.findWinningPosition();
        List<String> winnersNames = raceManager.findWinningCarsNames(winningPosition);
        OutputView.printWinner(winnersNames);
    }

}
