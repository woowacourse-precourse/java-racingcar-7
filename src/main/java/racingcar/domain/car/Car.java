package racingcar.domain.car;

import java.util.Objects;

public class Car {
    private final Name name;
    private final Distance distance;

    public Car(Name name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car createCarAtStartLine(String name) {
        return new Car(Name.from(name), Distance.createStartLine());
    }

    public void moveForward() {
        distance.addDistance();
    }

    public String getCarName() {
        return name.getName();
    }

    public Integer getCarDistance() {
        return distance.getDistance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car c = (Car) o;
        return Objects.equals(name.getName(), c.name.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name.getName());
    }
}
