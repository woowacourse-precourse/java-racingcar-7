package racingcar.domain.car;

import java.util.Objects;

public class Name {

    private final String value;

    private Name(String value) {
        this.value = value;
    }

    public static Name from(String value) {
        return new Name(value);
    }

    public String getValue() {
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
        return Objects.equals(getValue(), name.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
