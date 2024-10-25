package racingcar.model.car;

import java.util.Objects;
import racingcar.model.number.Number;

public class Car {
    private final Name name;
    private final Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void goOrStop(final Number number) {
        if (number.isGreaterThanForwardThreshold()) {
            position.increasePosition();
        }
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
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
        return Objects.hashCode(name);
    }
}
