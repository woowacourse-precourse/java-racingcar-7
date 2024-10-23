package racingcar.domain;

public class Car {
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Car(final String name) {
        this.name = name;
    }

    private void checkNameLength(final String name) {
    }
}
