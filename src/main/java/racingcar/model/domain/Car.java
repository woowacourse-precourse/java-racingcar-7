package racingcar.model.domain;

public class Car {

    private final String carName;
    private int currentDistance;

    public Car(String carName) {
        this.carName = carName;
        this.currentDistance = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getCurrentDistance() {
        return currentDistance;
    }
}
