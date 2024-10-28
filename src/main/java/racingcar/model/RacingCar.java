package racingcar.model;

public class RacingCar {
    String carName;
    int currentPosition;

    public RacingCar(String carName) {
        this.carName = carName;
        this.currentPosition = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void moveForward() {
        this.currentPosition++;
    }

}

