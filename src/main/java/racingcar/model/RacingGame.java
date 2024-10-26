package racingcar.model;

import java.util.List;
import java.util.Map;

public class RacingGame {
    private final RaceCars raceCars;
    private final AttemptCount attemptCount;

    public RacingGame(RaceCars raceCars, AttemptCount attemptCount) {
        this.raceCars = raceCars;
        this.attemptCount = attemptCount;
    }

    public void race() {
        raceCars.race();
        attemptCount.decrease();
    }

    public boolean canRace() {
        return attemptCount.canRace();
    }

    public Map<String, Integer> findCurrentPosition() {
        return raceCars.getCarPositions();
    }

    public List<String> findWinnerNames() {
        return raceCars.findWinnerNames();
    }
}
