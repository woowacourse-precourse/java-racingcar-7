package racingcar.domain;

import racingcar.exception.ErrorMessage;

public class Name {

    private static final String PATTERN = "^[a-z|A-Z]*$";

    private final String name;

    public Name(String name) {
        this.name = validate(name);
    }

    public String getName() {
        return name;
    }

    private static String validate(String name) {
        validateLength(name);
        validateEnglish(name);

        return name;
    }

    private static void validateEnglish(String name) {
        if (isNotEnglish(name)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_NOT_ENGLISH.getMessage());
        }
    }

    private static boolean isNotEnglish(String name) {
        return !name.matches(PATTERN);
    }

    private static void validateLength(String name) {
        if (isOverFive(name)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_OVER_FIVE.getMessage());
        }
    }

    private static boolean isOverFive(String name) {
        return name.length() > 5;
    }
}
