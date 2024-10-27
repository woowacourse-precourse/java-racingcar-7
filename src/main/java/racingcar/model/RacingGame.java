package racingcar.model;

import racingcar.utils.NumberGenerator;

import java.util.List;
import java.util.Map;

public class RacingGame {
    private final RaceCars raceCars;
    private final AttemptCount attemptCount;
    private final NumberGenerator numberGenerator;

    public RacingGame(RaceCars raceCars, AttemptCount attemptCount, NumberGenerator numberGenerator) {
        this.raceCars = raceCars;
        this.attemptCount = attemptCount;
        this.numberGenerator = numberGenerator;
    }

    public void race() {
        raceCars.race(numberGenerator);
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
