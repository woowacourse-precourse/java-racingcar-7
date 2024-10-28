package racingcar.domain;

public class Car {
    private final String carName;
    private int mileage = 0;

    private Car(String carName) {
        this.carName = carName;
    }

    public static Car registerCarNameFrom(String carName) {
        return new Car(carName);
    }

    public void moveCar() {
        this.mileage += 1;
    }
}
