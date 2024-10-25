package racingcar.model.name;

import java.util.Objects;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;
    private static final String NAME_ERROR_MESSAGE = "이름은 " + NAME_MAX_LENGTH + "글자 이하로 입력해주세요.";

    private final String name;

    public Name(String name) {
        this.name = isValid(name);
    }

    private String isValid(String name){
        if(name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
        return name;
    }

    public String getName() {
        return name;
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
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
