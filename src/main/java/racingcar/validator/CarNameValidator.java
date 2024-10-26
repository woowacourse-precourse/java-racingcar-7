package racingcar.validator;

import racingcar.message.ExceptionMessage;

import static racingcar.message.ExceptionMessage.*;

public class CarNameValidator {

    public static void validate(String name) {
        validateBlank(name);
        validateCarNameLength(name);
    }

    private static void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_OVER_FIVE_LENGTH.getMessage());
        }
    }

    private static void validateBlank(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_NOT_BLANK.getMessage());
        }
    }
}
