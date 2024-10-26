package racingcar.model.primitive;

import java.util.List;
import java.util.Objects;

public class Name {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    public static Name from(String name) {
        return new Name(name);
    }

    private void validate(String name) {
        if (isOutOfLength(name)) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private boolean isOutOfLength(String name) {
        return name.length() > MAX_CAR_NAME_LENGTH;
    }

    public void add(List<String> winners) {
        winners.add(this.name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
