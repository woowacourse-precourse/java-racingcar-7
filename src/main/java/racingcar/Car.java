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

        return new Car(this.carName, this.carPosition);
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

    public String toCustomFormatString(String carFormat, String positionFormat) {
        return this.carName.toString() + carFormat + this.carPosition.toCustomFormatString(positionFormat);
    }

    public String toCarNameString() {
        return this.carName.toString();
    }
}
