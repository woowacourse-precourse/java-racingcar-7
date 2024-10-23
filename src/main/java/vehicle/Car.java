package vehicle;

import policy.RacingPolicy;

public class Car implements Vehicle{
    private final String carName;
    private final RacingPolicy racingPolicy;
    private Long moveForwardCount;

    public Car(String carName, RacingPolicy racingPolicy, Long moveForwardCount) {
        this.carName = carName;
        this.racingPolicy = racingPolicy;
        this.moveForwardCount = moveForwardCount;
    }
    public Car(String carName, RacingPolicy racingPolicy) {
        this.carName = carName;
        this.racingPolicy = racingPolicy;
        this.moveForwardCount = 0L;
    }

    @Override
    public RacingPolicy getRacingPolicy() {
        return this.racingPolicy;
    }

    @Override
    public String getVehicleName() {
        return this.carName;
    }

    @Override
    public Long getMoveForwardCount() {
        return this.moveForwardCount;
    }
}
