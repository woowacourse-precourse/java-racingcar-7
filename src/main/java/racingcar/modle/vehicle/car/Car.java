package racingcar.modle.vehicle.car;

import racingcar.movableStrategy.MoveStrategy;
import racingcar.modle.vehicle.Movable;

public class Car implements Movable {
    private static final int START_POSITION = 0;

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(START_POSITION);
    }

    private Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    @Override
    public Car move(MoveStrategy moveStrategy) {
        int movedPosition = getPosition() + moveStrategy.movePoint();
        return new Car(getName(), movedPosition);
    }

    @Override
    public String getName() {
        return name.getName();
    }

    @Override
    public int getPosition() {
        return position.getPosition();
    }
}
