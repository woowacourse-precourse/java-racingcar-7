package racingcar.util;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;

public class RaceRoundParser {
    public static int parseRaceRound(String rawRaceRound) {
        validateNumberFormat(rawRaceRound);
        try {
            return Integer.parseInt(rawRaceRound);
        } catch (NumberFormatException e) {
            throw new RacingCarException(ErrorMessage.INVALID_INTEGER_FORMAT);
        }
    }

    private static void validateNumberFormat(String rawRaceRound) {
        if (!rawRaceRound.matches("\\d+")) {
            throw new RacingCarException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }
}
