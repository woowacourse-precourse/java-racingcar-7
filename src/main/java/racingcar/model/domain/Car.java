package racingcar.model.domain;

public class Car {

    private String name;
    private CarStatus status;
    private Integer movingForwardCount;

    public Car(String name) {
        this.name = name;
        this.status = CarStatus.STOP;
        this.movingForwardCount = 0;
    }

    public String getName() {
        return name;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void modifyStatus(CarStatus status) {
        this.status = status;
    }

    public Integer getMovingForwardCount() {
        return movingForwardCount;
    }

    public void modifyStatusFromRandomNumber(int randomNumber) {
        if (randomNumber >= 4) {
            this.status = CarStatus.MOVING_FORWARD;
        } else {
            this.status = CarStatus.STOP;
        }
    }

    public void moveBasedOnStatus() {
        if (this.status == CarStatus.MOVING_FORWARD) {
            this.movingForwardCount++;
        }
    }
}
