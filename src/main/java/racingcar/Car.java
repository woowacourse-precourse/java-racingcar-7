package racingcar;

public class Car {
    private final CarName carName;

    private final CarPosition carPosition;

    public Car(String name) {
        this.carName = new CarName(name);
        this.carPosition = new CarPosition();
    }

    private Car(CarName carName, CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public Car move() {
        this.carPosition.updateCurrentPosition();

        return new Car(new CarName(this.carName), new CarPosition(this.carPosition));
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
