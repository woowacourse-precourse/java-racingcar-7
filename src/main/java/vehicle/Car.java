package vehicle;

import policy.RacingPolicy;

public class Car implements Vehicle{
    private final String carName;
    private final RacingPolicy racingPolicy;
    private final Long moveForwardCount;

    public Car(String carName, RacingPolicy racingPolicy, Long moveForwardCount) {
        this.carName = carName;
        this.racingPolicy = racingPolicy;
        this.moveForwardCount = moveForwardCount;
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
