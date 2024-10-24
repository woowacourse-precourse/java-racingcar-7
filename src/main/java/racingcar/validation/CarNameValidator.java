package racingcar.validation;

import racingcar.enums.ErrorMessage;

public class CarNameValidator {

    public static void validate(String input) {
        validateSeparatorWithoutComma(input);
    }

    private static void validateSeparatorWithoutComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_COMMA.getMessage());
        }
    }

    public static void validateCar(String input) {

    }
}
