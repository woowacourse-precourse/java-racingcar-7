package racingcar.racing;

import racingcar.domain.*;
import racingcar.dto.InputDto;

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

    public static RacingGame initGame(InputDto dto) {
        RaceManager manager = RaceManager.createRaceManager(dto);
        return new RacingGame(manager);
    }
}
