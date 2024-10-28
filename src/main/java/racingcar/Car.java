package racingcar;

public class Car {
    private String carName;
    private int movement = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getDistance() {
        return "-".repeat(movement);
    }

    public String getCarName() {
        return carName;
    }

    public int getMovement() {
        return movement;
    }

    public void move() {
        ++movement;
    }

}
