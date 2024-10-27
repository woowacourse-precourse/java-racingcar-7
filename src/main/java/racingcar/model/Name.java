package racingcar.model;

import static racingcar.message.ErrorMessages.CLEAR_NAME;

import racingcar.exception.InvalidInputException;

public class Name {
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
    }

    private void validateClearName(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidInputException(CLEAR_NAME);
        }
    }
}
