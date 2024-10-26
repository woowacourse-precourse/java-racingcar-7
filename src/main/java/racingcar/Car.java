package racingcar;

public class Car {
    private String carName;
    private int distance;

    public Car(String carName) {
        this.carName = carName;
        this.distance = 0;
    }

    public String getCarName() {
        return carName;
    }
    public  int getDistance() {
        return distance;
    }
}
