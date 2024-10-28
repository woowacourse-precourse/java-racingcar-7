package racingcar.Domain;

import racingcar.Message.ErrorMessage;

public class CarNameValidator {
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

    private static void validateCharacters(String name) {
        if (!name.matches("[a-zA-Z0-9가-힣]+")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_INVALID_CHARACTER);
        }
    }

    public static void validate(String name) {
        validateBlank(name);
        validateLength(name);
        validateCharacters(name);

    }

}
