package racingcar.name;

import java.util.Objects;

public class Name {

    private final int MAXIMUM_NAME_LENGTH = 5;
    private final String NAME_LENGTH_HAVE_TO_UNDER_FIVE = "입력한 이름의 길이는 5보다 클 수 없습니다.";

    private final String name;

    public Name(String name) {
        validateLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_HAVE_TO_UNDER_FIVE);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Name)) {
            return false;
        }
        Name other = (Name) object;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
