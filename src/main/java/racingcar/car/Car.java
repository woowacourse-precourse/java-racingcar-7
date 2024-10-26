package racingcar.car;

import racingcar.strategy.MovingStrategy;

public class Car {

    private final Name name;
    private final MovingStrategy movingStrategy;

    public Car(final String name, final MovingStrategy movingStrategy) {
        this.name = new Name(name);
        this.movingStrategy = movingStrategy;
    }

    public boolean doesMove() {
        return movingStrategy.canMove();
    }

    public String name() {
        return name.value();
    }
}
