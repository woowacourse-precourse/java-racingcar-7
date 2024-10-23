package racingcar.model;

import java.util.Objects;

public class Name {

    private static final int NAME_MAX_LENGTH = 5;
    private static final String ERROR_PREFIX = "[ERROR] ";
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
            throw new IllegalArgumentException(ERROR_PREFIX + "이름은 null 또는 빈 문자열일 수 없습니다.");
        }
    }

    private void checkNameFormat(final String value) {
        if (!value.matches(NAME_FORMAT_PATTERN)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "이름은 영어 또는 한글로만 이루어져 있어야 합니다.");
        }
    }

    private void checkNameLength(final int length) {
        if (length > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_PREFIX + "이름은 " + NAME_MAX_LENGTH + "자 이하여야 합니다.");
        }
    }
}