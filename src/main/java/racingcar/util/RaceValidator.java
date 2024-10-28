package racingcar.util;

import racingcar.error.ErrorMessage;

public class RaceValidator {

    public void checkRaceCount(int raceCount) {
        if (raceCount <= 0 || 100 < raceCount) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RACE_COUNT.getMessage());
        }
    }
}
