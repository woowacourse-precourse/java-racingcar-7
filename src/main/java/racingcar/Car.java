package racingcar;

public class Car {
    private final CarName carName;

    private CarPosition carPosition;

    public Car(CarName carName) {
        this.carName = carName;
        this.carPosition = new CarPosition(0);
    }

    public void move() {
        this.carPosition = this.carPosition.updateCurrentPosition();
    }

    public boolean isAheadOrEqual(Car otherCar) {
        return this.carPosition.isAheadOrEqual(otherCar.carPosition);
    }

    public boolean isName(String givenName) {
        return carName.isName(givenName);
    }

    public boolean isPosition(int givenPosition) {
        return this.carPosition.isPosition(givenPosition);
    }

    public CarName getCarName() {
        return carName;
    }

    public CarPosition getCarPosition() {
        return carPosition;
    }
}
