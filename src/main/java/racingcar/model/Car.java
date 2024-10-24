package racingcar.model;

import static racingcar.constants.ErrorMessage.NOT_ALLOWED_CAR_NAME_LENGTH;

public class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    String name;

    public Car(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        validateLength(name);
    }

    private void validateLength(final String name) {
        if (MAX_CAR_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(NOT_ALLOWED_CAR_NAME_LENGTH);
        }
    }
}
