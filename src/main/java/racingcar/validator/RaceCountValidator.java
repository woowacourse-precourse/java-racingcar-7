package racingcar.validator;

import static racingcar.validator.ErrorMessages.INVALID_COUNT_RANGE;
import static racingcar.validator.ErrorMessages.INVALID_COUNT_TYPE;
import static racingcar.validator.ValidateConstants.MIN_RACE_COUNT;

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
        if (raceCount < MIN_RACE_COUNT.getValue()) {
            throw new IllegalArgumentException(INVALID_COUNT_RANGE.getMessage());
        }
    }

}
