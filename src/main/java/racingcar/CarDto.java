package racingcar;

public class CarDto {

    private final String carName;
    private final boolean isMoving;

    public CarDto(String carName, boolean isMoving) {
        this.carName = carName;
        this.isMoving = isMoving;
    }

    public String getCarName() {
        return carName;
    }

    public boolean isMoving() {
        return isMoving;
    }


}
