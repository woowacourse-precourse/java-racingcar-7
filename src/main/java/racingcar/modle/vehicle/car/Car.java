package racingcar.modle.vehicle.car;

import racingcar.modle.vehicle.Movable;

public class Car implements Movable {
    private static final int START_POSITION = 0;
    private static final int PLUS_ONE = 1;

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
    public Car move(){
        return new Car(name.getName(), position.getPosition() + PLUS_ONE);
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
