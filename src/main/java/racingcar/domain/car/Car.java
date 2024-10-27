package racingcar.domain.car;

import racingcar.domain.car.strategy.MoveStrategy;

public class Car {
    private final String name;
    private final MoveStrategy moveStrategy;

    private long position;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public long getPosition() {
        return position;
    }

    public void move() {
        position = moveStrategy.move(position);
    }
}
