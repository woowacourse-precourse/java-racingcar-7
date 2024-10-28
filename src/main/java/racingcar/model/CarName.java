package racingcar.model;

import racingcar.constants.ErrorMessages;

public class CarName {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validateBlank(name);
        validateLength(name);
        this.name = name;
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.BLANK_NAME);
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NAME_LENGTH);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
