package racingcar;

public class Car {
    private final String name;

    private final CarPosition carPosition;

    public Car(String name) {
        this.name = name;
        this.carPosition = new CarPosition(0);
    }

    private Car(String name, CarPosition carPosition) {
        this.name = name;
        this.carPosition = carPosition;
    }

    public Car move() {
        return new Car(this.name, this.carPosition.updateCurrentPosition());
    }

    public boolean isAheadOrEqual(Car otherCar) {
        return this.carPosition.isAheadOrEqual(otherCar.carPosition);
    }


    public boolean isName(String givenName) {
        return name.equals(givenName);
    }

    public boolean isPosition(int givenPosition) {
        return this.carPosition.isPosition(givenPosition);
    }

    public String toCustomFormatString(String customString) {
        return this.name + " : " + carPosition.toCustomFormatString(customString);
    }
}
