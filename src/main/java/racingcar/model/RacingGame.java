package racingcar.model;

import java.util.Map;

public class RacingGame {
    private final RaceCars raceCars;
    private final AttemptCount attemptCount;

    public RacingGame(RaceCars raceCars, AttemptCount attemptCount) {
        this.raceCars = raceCars;
        this.attemptCount = attemptCount;
    }

    public void race(){
        raceCars.race();
        attemptCount.decrease();
    }

    public Map<String, Integer> findCurrentPosition() {
        return raceCars.getCarPositions();
    }
}
