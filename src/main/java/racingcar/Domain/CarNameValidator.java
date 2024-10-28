package racingcar.Domain;

import racingcar.Message.ErrorMessage;

public class CarNameValidator {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validate(String name) {
        validateBasics(name);
        validateFormat(name);
    }

    private static void validateBasics(String name) {
        validateBlank(name);
        validateLength(name);
    }

    private static void validateFormat(String name) {
        validateCharacters(name);
    }

    private static void validateBlank(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_BLANK);
        }
    }

    private static boolean isBlank(String name) {
        return name == null || name.trim().isEmpty();
    }

    private static void validateLength(String name) {
        if (exceedsMaxLength(name)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_LENGTH);
        }
    }

    private static boolean exceedsMaxLength(String name) {
        return name.trim().length() > MAX_NAME_LENGTH;
    }

    private static void validateCharacters(String name) {
        if (containsInvalidCharacters(name)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_INVALID_CHARACTER);
        }
    }

    private static boolean containsInvalidCharacters(String name) {
        return !name.matches("[a-zA-Z0-9가-힣]+");
    }
}
