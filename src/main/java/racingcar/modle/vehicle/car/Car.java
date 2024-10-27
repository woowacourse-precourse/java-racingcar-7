package racingcar.modle.vehicle.car;

import racingcar.modle.movableStrategy.MovableStrategy;
import racingcar.modle.vehicle.Movable;

public class Car implements Movable {
    private static final int START_POSITION = 0;

    private final Name name;
    private final Position position;
    private MovableStrategy movableStrategy;

    public Car(String name, MovableStrategy movableStrategy) {
        this.name = new Name(name);
        this.position = new Position(START_POSITION);
        this.movableStrategy = movableStrategy;
    }

    private Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    @Override
    public Car move(){
        return new Car(name.getName(), position.getPosition() + movableStrategy.move());
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
