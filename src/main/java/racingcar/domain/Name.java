package racingcar.domain;

public class Name {
    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 넘을 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
