package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_FORM = "[A-Za-z0-9]+";

    private final String name;
    private int moveCount = 0;

    public Car(final String name) {
        checkNameLength(name);
        checkNameForm(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    private void checkNameLength(final String name) {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNameForm(final String name) {
        if (!name.matches(NAME_FORM)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
