package racingcar;

import static racingcar.Constants.MOVE_INDICATOR;

public class Car {
    private final String name;
    private final StringBuilder moving;

    public Car(String name) {
        this.name = name;
        this.moving = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public String getMoving() {
        return moving.toString();
    }

    public int getMovingCount() {
        return moving.length();
    }

    public void moveForward() {
        moving.append(MOVE_INDICATOR);
    }
}
