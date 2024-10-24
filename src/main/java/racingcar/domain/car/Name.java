package racingcar.domain.car;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateUserNameLength(name);
        this.name = name;
    }

    private void validateUserNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
