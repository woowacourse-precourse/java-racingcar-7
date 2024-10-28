package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class Car {
    private final String name;
    private int distance;
    private static final int MOVE_THRESHOLD = 4;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move() {
        if (isMovable()) {
            advance();
        }
    }

    private boolean isMovable() {
        int randomValue = pickNumberInRange(0, 9);
        return randomValue >= MOVE_THRESHOLD;
    }

    private void advance() {
        distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }
}
