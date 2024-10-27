package racingcar.domain;

public class Car {

    private static final String STATUS_CHARACTER = "-";

    private final CarName name;
    private final CarPosition carPosition;

    public Car(CarName name, CarPosition carPosition) {
        this.name = name;
        this.carPosition = carPosition;
    }

    public void move() {
        carPosition.increasePosition();
    }

    public CarPosition getPosition() {
        return carPosition;
    }

    public CarName getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name.getName(), STATUS_CHARACTER.repeat(carPosition.getPosition()));
    }
}
