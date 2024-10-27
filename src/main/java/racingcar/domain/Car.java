package racingcar.domain;

import static racingcar.constants.GameConstants.*;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isMoved(int randomNumber) {
        return randomNumber >= MOVE_THRESHOLD;
    }

    public void move() {
        distance++;
    }
}
