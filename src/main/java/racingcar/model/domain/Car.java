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

    public void modifyMovingForwardCount(Integer movingForwardCount) {
        this.movingForwardCount = movingForwardCount;
    }
}
