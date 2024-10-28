package racingcar.validator;

import static racingcar.validator.ErrorMessages.INVALID_COUNT_RANGE;
import static racingcar.validator.ErrorMessages.INVALID_COUNT_TYPE;

public class RaceCountValidator {

    public static int validateRaceCount(String raceCount) {
        int count = validateType(raceCount);
        validateCountRange(count);

        return count;
    }

    private static int validateType(String raceCount) {
        int count;
        try {
            count = Integer.parseInt(raceCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_COUNT_TYPE.getMessage());
        }

        return count;
    }

    private static void validateCountRange(int raceCount) {
        if (raceCount < 1) {
            throw new IllegalArgumentException(INVALID_COUNT_RANGE.getMessage());
        }
    }

}
