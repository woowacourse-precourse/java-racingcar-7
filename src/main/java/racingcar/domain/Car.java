package racingcar.domain;

import racingcar.util.RandomGenerator;

public class Car {
    private final String name;
    private int distance;
    private final RandomGenerator randomGenerator;

    private static final int MOVE_THRESHOLD = 4;

    public Car(String name, RandomGenerator randomGenerator) {
        this.name = name;
        this.randomGenerator = randomGenerator;
        this.distance = 0;
    }

    public void move() {
        if (isMovable()) {
            advance();
        }
    }

    private boolean isMovable() {
        int randomValue = randomGenerator.pickNumberInRange(0, 9);
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
