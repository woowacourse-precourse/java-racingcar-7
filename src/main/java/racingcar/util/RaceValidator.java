package racingcar.util;

import racingcar.error.ErrorMessage;

public class RaceValidator {

    private static final int MIN_RACE_COUNT = 1;
    private static final int MAX_RACE_COUNT = 100;

    public void checkRaceCount(int raceCount) {
        if (raceCount < MIN_RACE_COUNT || MAX_RACE_COUNT < raceCount) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RACE_COUNT.getMessage());
        }
    }
}