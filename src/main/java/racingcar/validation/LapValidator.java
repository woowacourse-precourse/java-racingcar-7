package racingcar.validation;

import racingcar.validation.exceptions.ValidationException;

public class LapValidator {

    public static void run(String lap) {
        validateLpa(lap);
    }

    private static void validateLpa(String lap) {
        ValidationException.isPositiveNumber(lap);
    }
}
