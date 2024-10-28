package racingcar.model;

import java.util.Objects;

public class Car {
    private final CarName name;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Car car) {
            return name.equals(car.name) && position == car.position;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
