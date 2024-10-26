package racingcar.validation;

import static racingcar.view.ErrorMessage.INVALID_CAR_NUMBER;

public class NameValidator {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    public static void validateNameLengthWithinLimit(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NUMBER.format());
        }
    }

    public static void validateTrailingComma(String name) {
        if (name.endsWith(",")) {
            throw new IllegalArgumentException(INVALID_CAR_NUMBER.format());
        }
    }

    public static void validateNameNotEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(INVALID_CAR_NUMBER.format());
        }
    }
}
