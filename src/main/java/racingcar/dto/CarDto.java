package racingcar.dto;

public class CarDto {
    private String carName;
    private int currentPosition;

    public CarDto(String carName, int currentPosition) {
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
