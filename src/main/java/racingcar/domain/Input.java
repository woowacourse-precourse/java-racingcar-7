package racingcar.domain;

import static racingcar.constans.exception.ErrorMessage.EMPTY_CAR_NAME_NOT_ALLOWED;
import static racingcar.constans.exception.ErrorMessage.INVALID_CAR_NAME_FORMAT;

public class Input {

    private final String names;

    private Input(String names) {
        Validator.validateInput(names);
        this.names = names;
    }

    public static Input from(String text) {
        return new Input(text);
    }

    public String getNames() {
        return names;
    }

    private static class Validator {

        private static void validateInput(String text) {
            validateNonEmptyInput(text);
            validateCommaSeparatedEnglishNames(text);
        }

        private static void validateNonEmptyInput(String text) {
            if (text == null || text.isEmpty() || text.isBlank()) {
                throw new IllegalArgumentException(EMPTY_CAR_NAME_NOT_ALLOWED.getMessage());
            }
        }

        private static void validateCommaSeparatedEnglishNames(String text) {
            if (!text.matches("^[a-zA-Z,]+$")) {
                throw new IllegalArgumentException(INVALID_CAR_NAME_FORMAT.getMessage());
            }
        }

    }

}