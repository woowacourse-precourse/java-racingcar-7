package racingcar.model;

import static racingcar.common.ErrorMessage.PARSE_ERROR_STRING_TO_INT;
import static racingcar.common.Validator.validateRaceCountSize;

public record RaceCount(int raceCount) {

    public static RaceCount of(String raceCount) {
        int parsedRaceCount;

        try {
            parsedRaceCount = Integer.parseInt(raceCount);
        } catch (Exception e) {
            throw new IllegalArgumentException(PARSE_ERROR_STRING_TO_INT.getMessage());
        }

        validateRaceCountSize(parsedRaceCount);
        return new RaceCount(parsedRaceCount);
    }
}
