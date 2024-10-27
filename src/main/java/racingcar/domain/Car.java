package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_FORM = "[A-Za-z0-9]+";
    private static final int MOVEMENT_CONDITION = 4;

    private final String name;
    private int moveCount;

    public Car(String name, int moveCount) {
        checkNameLength(name);
        checkNameForm(name);
        this.name = name;
        this.moveCount = moveCount;
    }

    public void move(int number) {
        if (MOVEMENT_CONDITION <= number) {
            ++moveCount;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
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

    private void checkNameLength(String name) {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNameForm(String name) {
        if (!name.matches(NAME_FORM)) {
            throw new IllegalArgumentException();
        }
    }
}
