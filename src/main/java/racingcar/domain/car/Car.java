package racingcar.domain.car;

import java.util.Objects;

public class Car {
    private final CarName name;
    private final Position position;

    private Car(String name) {
        this.name = CarName.from(name);
        this.position = Position.create();
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public void move() {
        position.add();
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
        return Objects.hashCode(name);
    }
}
