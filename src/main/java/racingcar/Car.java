package racingcar;

public class Car {
    private final CarName carName;

    private final CarPosition carPosition;

    public Car(String name) {
        this.carName = new CarName(name);
        this.carPosition = new CarPosition(0);
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

    public String toCustomFormatString(String customString) {
        return this.carName.toString() + " : " + this.carPosition.toCustomFormatString(customString);
    }
    public String toCarNameString(){
        return this.carName.toString();
    }
}
