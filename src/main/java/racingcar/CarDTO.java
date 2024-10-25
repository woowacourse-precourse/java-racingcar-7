package racingcar;

public class CarDTO {
    private final String carName;
    private final int currentPosition;

    public CarDTO(String carName, int currentPosition) {
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
