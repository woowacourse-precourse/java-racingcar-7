package racingcar.validation;

import static racingcar.service.exception.RaceCountExceptionMessage.RACE_COUNT_CANNOT_BLANK;
import static racingcar.service.exception.RaceCountExceptionMessage.RACE_COUNT_MUST_DIGIT;

import racingcar.service.exception.RaceCountException;

public class RaceCountValidator {

    public static String validateRaceCount(String raceCount) {
        validateRaceCountBlank(raceCount);
        validateRaceCountDigit(raceCount);
        return raceCount;
    }

    private static void validateRaceCountBlank(String raceCount) {
        if (raceCount.isBlank() || raceCount == null) {
            throw new RaceCountException(RACE_COUNT_CANNOT_BLANK);
        }
    }

    private static void validateRaceCountDigit(String raceCount) {
        try {
            Long.parseLong(raceCount);
        } catch (NumberFormatException e) {
            throw new RaceCountException(RACE_COUNT_MUST_DIGIT);
        }
    }
}
