package racingcar.vo;

import static racingcar.constant.ExceptionMessage.INVALID_CAR_NAME_LENGTH;

import java.util.Objects;

public class Name {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String value;

    private Name(String value) {
        validateLength(value);
        this.value = value;
    }

    public static Name from(String value) {
        return new Name(value);
    }

    private static void validateLength(String value) {
        int length = value.length();

        if (length < MIN_LENGTH || length > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.format(MIN_LENGTH, MAX_LENGTH));
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Name name)) {
            return false;
        }
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
