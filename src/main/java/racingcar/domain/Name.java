package racingcar.domain;

public class Name {
    private final String value;

    public Name(String value) {
        if (value.length() > 6) {
            throw new IllegalArgumentException("이름은 5자를 넘을 수 없습니다.");
        }
        this.value = value;
    }

    public boolean isMatch(Name name) {
        return value.equals(name.value);
    }

    @Override
    public String toString() {
        return value;
    }
}
