package racingcar.model;

import java.util.Objects;
import racingcar.common.exception.CarException;
import racingcar.common.exception.CarValidationError;

public class Name {

    private static final int NAME_MAX_LENGTH = 5;
    private static final String NAME_FORMAT_PATTERN = "^[a-zA-Z가-힣]+$";

    private final String value;

    private Name(final String value) {
        validate(value);
        this.value = value;
    }

    public static Name from(final String value) {
        return new Name(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private void validate(final String value) {
        checkNullOrEmpty(value);
        checkNameFormat(value);
        checkNameLength(value.length());
    }

    private void checkNullOrEmpty(final String value) {
        if (value == null || value.isEmpty()) {
            throw new CarException(CarValidationError.NULL_OR_EMPTY_NAME_EXCEPTION.getMessage());
        }
    }

    private void checkNameFormat(final String value) {
        if (!value.matches(NAME_FORMAT_PATTERN)) {
            throw new CarException(CarValidationError.INVALID_NAME_FORMAT_EXCEPTION.getMessage());
        }
    }

    private void checkNameLength(final int length) {
        if (length > NAME_MAX_LENGTH) {
            throw new CarException(CarValidationError.EXCEEDS_MAX_LENGTH_EXCEPTION.getMessage(NAME_MAX_LENGTH));
        }
    }
}