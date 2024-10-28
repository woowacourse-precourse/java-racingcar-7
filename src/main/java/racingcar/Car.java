package racingcar;

public class Car {

    private final String carName;
    private int distance = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public void move() {
        distance++;
    }

    public void stop() {

    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }
}
