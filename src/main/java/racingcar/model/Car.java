package racingcar.model;

import java.util.Objects;

public record Car(String name, int distance) {

    public Car move() {
        return new Car(name, distance + 1);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }
}
