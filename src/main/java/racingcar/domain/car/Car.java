package racingcar.domain.car;

import racingcar.domain.strategy.MovingStrategy;

public class Car {
    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(MovingStrategy strategy) {
        if (strategy.isMovable()) {
            position = position.forward();
        }
    }

    public boolean isAtPosition(int maxPosition) {
        return position.isSameAs(new Position(maxPosition));
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getCurrentStatus() {
        return name.toString() + " : " + "-".repeat(position.getValue());
    }
}