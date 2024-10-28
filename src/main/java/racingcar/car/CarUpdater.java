package racingcar.car;

import racingcar.decider.Decider;

public class CarUpdater implements Car {
    private final CarImpl car;
    private final Decider decider;
    public CarUpdater(CarImpl car, Decider decider) {
        this.car = car;
        this.decider = decider;
    }
    public void forward() {
        if (this.decider.decideMoveOrNot()) {
            this.car.forward();
        }
    }

    public String getName() {
        return this.car.getName();
    }

    public int getPosition() {
        return this.car.getPosition();
    }
}
