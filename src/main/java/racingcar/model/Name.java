package racingcar.model;

import java.util.Objects;
import racingcar.view.ErrorMessage;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private final String value;

    public Name(final String value) {
        String trimmedValue = value.trim();
        validateNameLength(trimmedValue);
        validateBlank(trimmedValue);
        this.value = trimmedValue;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Name)) {
            return false;
        }
        Name name = (Name) object;
        return Objects.equals(this.value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_INAPPROPRIATE.getMessage());
        }
    }
}
