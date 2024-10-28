package racingcar.domain.car;

import racingcar.domain.strategy.MovingStrategy;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
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
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}