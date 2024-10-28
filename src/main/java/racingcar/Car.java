package racingcar;

public class Car {
    private final String carName;
    private int distance;

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Car(String carName) {
        this.carName = carName;
        this.distance = 0;
    }
}
