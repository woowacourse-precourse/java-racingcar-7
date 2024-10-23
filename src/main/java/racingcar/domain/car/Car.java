package racingcar.domain.car;

import java.util.Objects;

public class Car {
    private static final int MOVE_FORWARD_UNIT = 1;
    private static final CarPosition DEFAULT_POSITION = CarPosition.of(0);
    private final CarName name;
    private final CarPosition carPosition;

    public Car(CarName carName) {
        this(carName, DEFAULT_POSITION);
    }

    public Car(CarName carName, CarPosition carPosition) {
        this.name = carName;
        this.carPosition = carPosition;
    }

    public Car moveForward() {
        return new Car(this.name, carPosition.apply(before -> before + MOVE_FORWARD_UNIT));
    }

    public CarName getName() {
        return name;
    }

    public CarPosition getCarPosition() {
        return carPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(carPosition, car.carPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, carPosition);
    }
}
