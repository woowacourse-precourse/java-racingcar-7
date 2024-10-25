package racingcar;

public class Car {
    private final String carName;
    private int distance;

    public Car(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getDistance() {
        return this.distance;
    }

    public void addDistance(final int distance) {
        this.distance += distance;
    }
}
