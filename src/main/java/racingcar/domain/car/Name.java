package racingcar.domain.car;

public class Name {

    private final int MAX_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_LENGTH + "자를 넘을 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
