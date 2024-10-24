package racingcar;

public class CarStatus {
    private String carName;
    private int currentPosition;

    public CarStatus(String carName, int currentPosition) {
        this.carName = carName;
        this.currentPosition = currentPosition;
    }

    public String getCarName() {
        return carName;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
