package racingcar.domain.car;

import racingcar.domain.strategy.MovingStrategy;

public class Car {
    private final Name name;
    private int position = 0;

    public Car(String name) {
        this.name = new Name(name);
    }

    public void move(MovingStrategy strategy) {
        if (strategy.isMovable()) {
            position++;
        }
    }

    public boolean isAtPosition(int maxPosition) {
        return position == maxPosition;
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return position;
    }

    public String getCurrentStatus() {
        return name.toString() + " : " + "-".repeat(position);
    }
}