package racingcar.Domain;

import racingcar.Message.ErrorMessage;

public class CarNameValidatator {
    private static final int MAX_NAME_LENGTH = 5;

    private static void validateBlank(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_BLANK);
        }
    }

    private static void validateLength(String name) {
        if (name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_LENGTH);
        }
    }

    public static void validate(String name) {
        validateBlank(name);
        validateLength(name);
    }

}
