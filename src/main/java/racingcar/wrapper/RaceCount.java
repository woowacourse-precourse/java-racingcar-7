package racingcar.wrapper;

import racingcar.validator.RaceCountValidator;

public class RaceCount {

    private final int raceCount;

    private RaceCount(String raceCount) {
        this.raceCount = RaceCountValidator.validateRaceCount(raceCount);
    }

    public static RaceCount of(String raceCount) {
        return new RaceCount(raceCount);
    }

    public int getRaceCount() {
        return raceCount;
    }

}
