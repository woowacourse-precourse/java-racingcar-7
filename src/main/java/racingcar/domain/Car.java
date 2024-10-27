package racingcar.domain;

public class Car {
    private final CarName carName;
    private final CarPosition carPosition;

    public Car(CarName carName) {
        this.carName = carName;
        this.carPosition = new CarPosition();
    }

    public void move() {
        carPosition.moveForward();
    }

    public int getPosition() {
        return carPosition.getCarPosition();
    }

    public String getName() {
        return carName.getName();
    }
}
