package racingcar.validation;

import racingcar.view.constant.ExceptionConstant;

public class NumberOfAttemptsValidator {
    public static final String NATURAL_NUMBER = "^[0-9]+$";

    private static boolean isValidInput(String input) {
        return input.matches(NATURAL_NUMBER);
    }

    private static boolean isNaturalNumber(String number) {
        return Integer.parseInt(number) >= 1;
    }

    public void validateNumberOfAttempts(String input) {
        if (!isValidInput(input))
            throw new IllegalArgumentException(ExceptionConstant.NOT_VALID_INPUT);
        if (!isNaturalNumber(input))
            throw new IllegalArgumentException(ExceptionConstant.NOT_NATURAL_NUMBER);
    }
}