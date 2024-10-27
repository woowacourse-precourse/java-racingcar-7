package racingcar.utils;

import static racingcar.exception.ExceptionMessage.*;

public class InputValidator {
    public static void inputCarsNameValidation(String inputCarsName) {
        if (inputCarsName.isBlank()) {
            throw new IllegalArgumentException(INPUT_NOT_BLANK);
        }
    }

    public static void tryNumberValidation(String tryNumberString) {
        try {
            Integer tryNumber = Integer.valueOf(tryNumberString);
            if (tryNumber <= 0) {
                throw new IllegalArgumentException(TRY_NUMBER_MUST_POSITIVE_INTEGER);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_NUMBER_MUST_POSITIVE_INTEGER);
        }
    }
}
