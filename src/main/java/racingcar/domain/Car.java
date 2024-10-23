package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Car(final String name) {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(final String name) {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
