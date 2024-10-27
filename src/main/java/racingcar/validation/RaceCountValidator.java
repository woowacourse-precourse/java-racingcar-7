package racingcar.validation;

import static racingcar.service.exception.RaceCountExceptionMessage.RACE_COUNT_CANNOT_BLANK;
import static racingcar.service.exception.RaceCountExceptionMessage.RACE_COUNT_MUST_DIGIT;
import static racingcar.service.exception.RaceCountExceptionMessage.RACE_COUNT_OVERFLOW;
import static racingcar.service.exception.RaceCountExceptionMessage.RACE_COUNT_UNDERFLOW;

import racingcar.service.exception.RaceCountException;

public class RaceCountValidator {

    public static String validateRaceCount(String raceCount) {
        validateRaceCountBlank(raceCount);
        validateRaceCountDigit(raceCount);
        validateRaceCountOverFlow(raceCount);
        validateRaceCountUnderFlow(raceCount);
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

    private static void validateRaceCountOverFlow(String raceCount) {
        if (Long.parseLong(raceCount) > Integer.MAX_VALUE) {
            throw new RaceCountException(RACE_COUNT_OVERFLOW);
        }
    }

    private static void validateRaceCountUnderFlow(String raceCount) {
        if (Long.parseLong(raceCount) < Integer.MIN_VALUE) {
            throw new RaceCountException(RACE_COUNT_UNDERFLOW);
        }
    }

}
