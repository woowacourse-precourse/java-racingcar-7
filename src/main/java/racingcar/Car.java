package racingcar;

import java.util.Objects;

public class Car {
    private final String name;
    private int distanceMovedForward;

    public Car(final String name) {
        validateNameLength(name);
        validateNameOnlyEnglishAndNumber(name);
        this.name = name;
        this.distanceMovedForward = 0;
    }

    public void moveForward() {
        distanceMovedForward++;
    }

    private void validateNameLength(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameOnlyEnglishAndNumber(final String name) {
        for (char c : name.toCharArray()) {
            validateCharOnlyEnglishAndNumber(c);
        }
    }

    private void validateCharOnlyEnglishAndNumber(final char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (Character.isDigit(c))) {
            return;
        }

        throw new IllegalArgumentException();
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car)) {
            return false;
        }
        Car car = (Car) obj;
        return Objects.equals(name, car.name);
    }
}