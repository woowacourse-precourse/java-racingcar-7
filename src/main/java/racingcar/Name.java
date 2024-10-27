package racingcar;

import java.util.Objects;

public class Name {

    private final String name;

    public Name(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("자동차 이름은 null 이거나 빈 칸일 수 없습니다. 입력된 이름: (%s)", name));
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(String.format("자동차 이름은 쉼표(,)를 기준으로 5글자이하로만 가능합니다. 입력된 이름: (%s)", name));
        }
        this.name = name.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public String getValue() {
        return this.name;
    }
}
