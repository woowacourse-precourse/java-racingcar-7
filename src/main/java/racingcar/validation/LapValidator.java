package racingcar.validation;

import racingcar.validation.exceptions.ValidationException;

public class LapValidator {

    public static void run(int lap) {
        validateLpa(lap);
    }

    private static void validateLpa(int lap) {
        ValidationException.isPositiveNumber(lap);
    }
}
