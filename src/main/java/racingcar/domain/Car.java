package racingcar.domain;

public class Car implements Vehicle{
    private final String carName;
    private Long moveForwardCount;

    public Car(String carName, Long moveForwardCount) {
        this.carName = carName;
        this.moveForwardCount = moveForwardCount;
    }

    public Car(String carName) {
        this.carName = carName;
        this.moveForwardCount = 0L;
    }

    @Override
    public String getVehicleName() {
        return this.carName;
    }

    @Override
    public Long getMoveForwardCount() {
        return this.moveForwardCount;
    }

    @Override
    public void move() {
        moveForwardCount+=1L;
    }

}
