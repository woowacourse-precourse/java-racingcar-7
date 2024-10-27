package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MOVABLE_MARGIN = 4;

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number >= MOVABLE_MARGIN) {
            distance += 1;
        }
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
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
