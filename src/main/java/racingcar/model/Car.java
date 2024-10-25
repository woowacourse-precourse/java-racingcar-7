package racingcar.model;

import java.util.Objects;

public class Car {

    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int MOVEABLE_LIMIT = 4;
    private final String name;
    private int location;

    public Car(String name) {
        validateName(name);
        this.name = name;
        location = 0;
    }

    private void validateName(String name) {
        if (isBlank(name) || isTooLong(name)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isBlank(String name) {
        return name.isBlank();
    }

    private boolean isTooLong(String name) {
        return name.length() > NAME_LENGTH_LIMIT;
    }

    public void moveIfPossible(int number) {
        if (isMoveable(number)) {
            location++;
        }
    }

    private boolean isMoveable(int number) {
        return number >= MOVEABLE_LIMIT;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car car)) {
            return false;
        }
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
