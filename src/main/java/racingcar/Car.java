package racingcar;

public class Car {

    private static final int MAX_LENGTH_OF_NAME = 5;

    private final String name;

    public Car(String name) {
        validate(name);

        this.name = name;
    }

    private void validate(final String name) {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }
}
