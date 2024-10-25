package racingcar;

import java.util.Objects;

public class Name {

    private final String name;
    private final String NAME_LENGTH_HAVE_TO_UNDER_FIVE = "입력한 이름의 길이는 5보다 클 수 없습니다.";

    public Name(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_HAVE_TO_UNDER_FIVE);
        }
        this.name = name;
    }

    public String getName() {
        return name;
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
