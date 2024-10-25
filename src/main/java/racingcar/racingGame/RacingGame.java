package racingcar.racingGame;

import racingcar.domain.*;
import racingcar.views.InputView;

public class RacingGame extends RacingGameTemplate {

    private final RaceManager raceManager;

    private RacingGame(RaceManager raceManager) {
        this.raceManager = raceManager;
    }

    @Override
    protected void race() {
        raceManager.racePerAttempt();
    }

    @Override
    protected void announceWinners() {
        raceManager.announceRaceResult();
    }

    public static RacingGame initGame() {
        RaceManager manager = RaceManager.createRaceManager(
                RacingCars.from(InputView.inputCarNames()),
                Attempts.from(InputView.inputRaceAttempts())
        );
        return new RacingGame(manager);
    }
}
