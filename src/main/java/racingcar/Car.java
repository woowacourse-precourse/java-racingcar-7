package racingcar;

import java.util.Objects;

public class Car {

    private final int NAME_MAX_LENGTH  = 5;
    private final int MINIMUM_DISTANCE = 4;

    private String name;
    private int location;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public Car(String name, int location) {
        validateName(name);
        this.name = name;
        this.location = location;
    }

    private void validateName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름이 5글자를 초과할 수 없어요.");
        }
    }

    public void moveForward(int distance) {
        if (MINIMUM_DISTANCE <= distance) {
            this.location = location + 1;
        }
    }

    public int currentLocation() {
        return this.location;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return location == car.location && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        return name + ", " + location;
    }
}
