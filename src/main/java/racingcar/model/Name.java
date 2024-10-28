package racingcar.model;

import static racingcar.message.ErrorMessages.CLEAR_NAME;
import static racingcar.message.ErrorMessages.LONG_NAME;

import racingcar.exception.InvalidInputException;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    private void validate(String name) {
        validateClearName(name);
        validateLongName(name);
    }

    private void validateClearName(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidInputException(CLEAR_NAME);
        }
    }

    private void validateLongName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new InvalidInputException(LONG_NAME);
        }
    }
}
