package racingcar.modle.vehicle.car;

import racingcar.modle.movableStrategy.MovableStrategy;

public class CarFactory {
    private MovableStrategy movableStrategy;

    public CarFactory(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }

    public Car create(String name) {
        return new Car(name, movableStrategy);
    }
}
