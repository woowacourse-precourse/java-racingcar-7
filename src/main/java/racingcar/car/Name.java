package racingcar.car;

import java.util.Objects;
import racingcar.exception.InvalidNameException;

public class Name {

    private final String value;

    public Name(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        if (value == null || value.isBlank()) {
            throw new InvalidNameException("이름은 null이거나 공백일 수 없습니다.");
        }
        if (value.length() > 5) {
            throw new InvalidNameException("이름은 5글자 이하여야 합니다.");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
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
}
