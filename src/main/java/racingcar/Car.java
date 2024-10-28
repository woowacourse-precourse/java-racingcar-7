package racingcar;

public class Car {

    private String carName;
    private int distance = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public void move() {
        distance++;
    }

    public void stop() {

    }

    private String getCarName() {
        return carName;
    }

    private int getDistance() {
        return distance;
    }
}
