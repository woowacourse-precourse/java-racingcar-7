package racingcar.model;

public class Car {
    private final String carName;
    private int distance;

    public Car(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public void move() {
        distance++;
    }

    @Override
    public String toString() {
        return carName + " : " + "-".repeat(distance);
    }

    public String getCarName() {
        return carName;
    }

    public int getCarMoved() {
        return distance;
    }
}