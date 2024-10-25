package racingcar.util;

import static racingcar.util.ConstantRacingData.INPUT_DELIMITER;
import static racingcar.util.ConstantRacingData.MINIMUM_RACING_CAR_NEEDED;
import static racingcar.util.message.ExceptionMessage.DELIMITER_POSITION_INCORRECT;
import static racingcar.util.message.ExceptionMessage.NEED_MULTIPLE_RACING_CAR;
import static racingcar.util.message.ExceptionMessage.TRIAL_COUNT_NOT_POSITIVE;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    public static List<String> validateInputString(String input) {
        if (input.isBlank() || input.startsWith(INPUT_DELIMITER) || input.endsWith(INPUT_DELIMITER)) {
            throw new IllegalArgumentException(DELIMITER_POSITION_INCORRECT.get());
        }
        return Arrays.stream(input.split(INPUT_DELIMITER))
                .map(String::strip)
                .toList();
    }

    public static void validateRacingCarCount(Integer nameCount) {
        if (nameCount < MINIMUM_RACING_CAR_NEEDED) {
            throw new IllegalArgumentException(NEED_MULTIPLE_RACING_CAR.get());
        }
    }

    public static int validateInteger(String trialCount) {
        try {
            return validatePositive(Integer.parseInt(trialCount));
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(e.getMessage(), e.fillInStackTrace());
        }
    }

    public static int validatePositive(Integer trialCount) {
        if (trialCount <= 0) {
            throw new IllegalArgumentException(TRIAL_COUNT_NOT_POSITIVE.get());
        }
        return trialCount;
    }
}
