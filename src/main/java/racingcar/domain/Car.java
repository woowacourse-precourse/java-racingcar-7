package racingcar.domain;

import java.util.Objects;

public class Car {

    private final String name;
    private int position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car move(int random) {
        if (random >= 4) {
            position += 1;
            return new Car(name, position);
        }
        return this;
    }

    public int comparePosition(int max) {
        return Math.max(max, position);
    }

    public boolean isSameForward(int max) {
        return position == max;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Car car)) {
            return false;
        }
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }

}
