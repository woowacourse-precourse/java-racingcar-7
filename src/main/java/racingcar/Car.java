package racingcar;

public class Car {
    private final String carName;
    private final int distance;

    public Car(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public String getCarName() {
        return this.carName;
    }
}
