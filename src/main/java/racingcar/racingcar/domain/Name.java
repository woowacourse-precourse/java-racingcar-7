package racingcar.racingcar.domain;

import racingcar.racingcar.validator.name.NameValidator;

import java.util.Objects;

public class Name {
    private final String name;
    public Name(String name) {
        NameValidator.withingRangeNameLength(name);
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Name that) {
            return this.name.equals(that.name);
        }
        return false;
    }
}
