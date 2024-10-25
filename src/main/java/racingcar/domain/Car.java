package racingcar.domain;

public class Car {

    private final CarName name;
    private final CarPosition carPosition;

    public Car(CarName name, CarPosition carPosition) {
        this.name = name;
        this.carPosition = carPosition;
    }

    public void move() {
        carPosition.increasePosition();
    }
}
