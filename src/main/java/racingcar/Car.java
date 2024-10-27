package racingcar;

public class Car {
    private static final int MAX_MOVEMENT_DISTANCE = 1;
    private CarStatus status;

    public Car(CarStatus status) {
        this.status = status;
    }

    public void move() {
        this.status = status.moveForward(MAX_MOVEMENT_DISTANCE);
    }

    public CarStatus getStatus() {
        return status;
    }
}
