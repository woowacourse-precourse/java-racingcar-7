package racingcar.model;

import java.util.Objects;
import racingcar.utils.Validator;

public class Car {
    private final Name name;
    private Distance distance;

    public Car(Name name) {
        this.name = name;
        this.distance = new Distance();
    }

    public static Car from(Name name) {
        return new Car(name);
    }

    public void move(MovementStrategy movingStrategy) {
        if (movingStrategy.moveable()) {
            distance.stepForward();
        }
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
        return Objects.equals(name, car.name) && Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public String getName() {
        return name.getName();
    }
}
