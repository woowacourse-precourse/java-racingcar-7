package racingcar.runner.dto;

public class CarDto {
    private String carName;
    private int movementStatus;

    public CarDto(String carName, int movementStatus) {
        this.carName = carName;
        this.movementStatus = movementStatus;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getMovementStatus() {
        return this.movementStatus;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setMovementStatus(int movementStatus) {
        this.movementStatus = movementStatus;
    }
}
