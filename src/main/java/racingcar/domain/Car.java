package racingcar.domain;

public class Car {
    private static final int MOVING_FORWARD = 4;
    private final String carName;
    private int distance = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int distance) {
        if(distance >= MOVING_FORWARD){
            this.distance += 1;
        }
    }
}
