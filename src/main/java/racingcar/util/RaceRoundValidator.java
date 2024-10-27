package racingcar.util;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;

public class RaceRoundValidator {
    private static final int MAX_RACE_ROUND = 100;
    private static final int MIN_RACE_ROUND = 0;

    public static void validateRaceRound(String rawRaceRound) {
        validateNumberFormat(rawRaceRound);
        int raceRound = parseRaceRound(rawRaceRound);
        validateRaceRoundInBound(raceRound);
    }

    private static void validateNumberFormat(String rawRaceRound) {
        if (!rawRaceRound.matches("\\d+")) {
            throw new RacingCarException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }

    private static void validateRaceRoundInBound(int raceRound) {
        if (raceRound < MIN_RACE_ROUND || raceRound > MAX_RACE_ROUND) {
            throw new RacingCarException(ErrorMessage.RACE_ROUND_OUT_OF_BOUND);
        }
    }

    private static int parseRaceRound(String rawRaceRound) {
        try {
            return Integer.parseInt(rawRaceRound);
        } catch (NumberFormatException e) {
            throw new RacingCarException(ErrorMessage.INVALID_INTEGER_FORMAT);
        }
    }
}
