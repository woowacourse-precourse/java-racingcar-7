package racingcar.model;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final Name name;
    private final Position position;
    private final CarMovementPolicy movementPolicy;

    public Car(final Name name, final CarMovementPolicy movementPolicy) {
        this.name = name;
        this.position = Position.defaultValue();
        this.movementPolicy = movementPolicy;
    }

    public void race(final int movementValue) {
        if (movementPolicy.isPossibleToMove(movementValue)) {
            position.moveForward();
        }
    }

    public boolean isSamePosition(final Car car) {
        return this.position.equals(car.position);
    }

    public String name() {
        return name.value();
    }

    public int position() {
        return position.value();
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
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Car other) {
        return this.position.compareTo(other.position);
    }
}
