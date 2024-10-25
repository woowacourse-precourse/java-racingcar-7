package racingcar.car;

import racingcar.strategy.MovingStrategy;

public class Car {

    private final String name;
    private final MovingStrategy movingStrategy;

    private long position;

    public Car(final String name, final MovingStrategy movingStrategy) {
        this.name = name;
        this.position = 0;
        this.movingStrategy = movingStrategy;
    }

    public void move() {
        if (movingStrategy.canMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public long getPosition() {
        return position;
    }
}
