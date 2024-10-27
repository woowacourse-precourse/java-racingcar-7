package racingcar.model;

import java.util.Objects;

public class Car {
    private Name name;
    private Position position;

    public Car(final Name name) {
        this.name = name;
        this.position = new Position();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Car)) {
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
