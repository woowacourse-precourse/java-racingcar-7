package racingcar.model;

import racingcar.enums.Constraints;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number >= Constraints.MOVE_CONDITION.getValue()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
