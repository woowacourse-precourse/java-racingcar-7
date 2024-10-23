package racingcar;

public class Car {

    private final String name;

    public Car(final String name) {
        validNameIsBlank(name);
        validNameLength(name);
        this.name = name;
    }

    private void validNameIsBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
        }
    }

    private void validNameLength(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }
}
