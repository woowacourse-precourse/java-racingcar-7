package racingcar.model;

import java.util.Objects;

public class Name {
    private final String value;

    public Name(final String value) {
        this.value = value;
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
}
