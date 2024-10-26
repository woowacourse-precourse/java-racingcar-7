package racingcar.domain;

import racingcar.enums.Constants;

public class Car {
    public final String name;
    public int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int value) {
        if (value >= Constants.MOVE_CONDITION.getValue()) {
            moveCount++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(moveCount);
    }
}
