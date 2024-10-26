package racingcar.racing;

import racingcar.domain.*;
import racingcar.dto.InputDto;
import racingcar.utils.moving.MovingByRandomNumber;

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
        RaceManager manager = RaceManager.createRaceManager(dto, new MovingByRandomNumber());
        return new RacingGame(manager);
    }
}
