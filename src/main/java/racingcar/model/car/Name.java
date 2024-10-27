package racingcar.model.car;

import java.util.Objects;
import racingcar.exception.InvalidNameException;

public class Name {

    public static final int MAX_LENGTH = 5;

    private final String name;

    public Name(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String value) {
        if (value == null || value.isBlank()) {
            throw new InvalidNameException("이름은 null이거나 공백일 수 없습니다.");
        }
        if (value.length() > MAX_LENGTH) {
            throw new InvalidNameException("이름은 5글자 이하여야 합니다.");
        }
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name other = (Name) o;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
