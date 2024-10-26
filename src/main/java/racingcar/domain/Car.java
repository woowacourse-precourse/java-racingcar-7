package racingcar.domain;

import racingcar.utils.moving.MovingStrategy;

public class Car {

    private final Name name;
    private final Position position;

    private Car(String name) {
        this.name = Name.from(name);
        this.position = Position.from();
    }

    public String getName() {
        return name.getName();
    }

    public int getPositionDistance() {
        return position.distance();
    }

    public String currentPositionFormat() {
        return name.getName() + " : " + position.getPosition();
    }

    public void move(MovingStrategy strategy) {
        if (strategy.isMovable()) {
            position.forward();
        }
    }

    public static Car from(String name) {
        return new Car(name);
    }
}
