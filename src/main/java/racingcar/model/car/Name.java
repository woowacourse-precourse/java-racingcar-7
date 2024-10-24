package racingcar.model.car;

import racingcar.common.ErrorMessage;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String VALID_NAME_REGEX = "^[a-zA-Z0-9]+$";
    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        validateNameLength(name);
        validateNameCharacters(name);
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getMessage());
        }
    }

    private void validateNameCharacters(final String name) {
        if (!name.matches(VALID_NAME_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_INVALID_CHARACTER.getMessage());
        }
    }

    public String getCarName() {
        return name;
    }
}
