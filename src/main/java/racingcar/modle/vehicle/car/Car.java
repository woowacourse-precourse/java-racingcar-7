package racingcar.modle.vehicle.car;

import racingcar.modle.vehicle.Movable;
import racingcar.movableStrategy.MoveStrategy;

public class Car implements Movable {
    private static final int START_POSITION = 0;

    private final Name name;
    private final Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position(START_POSITION);
    }

    private Car(final String name, final int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    @Override
    public Car move(final MoveStrategy moveStrategy) {
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
