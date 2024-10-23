package racingcar;

public class Car {

    private String carName;
    private int position;
    private String movementStatus;

    public Car(String carName) {
        this.carName = carName;
        position = 0;
        movementStatus = "";
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public String getMovementStatus() {
        return movementStatus;
    }

    public void moveForward() {
        position += 1;
    }

    public void addMovementStatus() {
        movementStatus += "-";
    }
}
