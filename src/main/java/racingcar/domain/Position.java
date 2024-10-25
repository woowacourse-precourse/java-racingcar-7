package racingcar.domain;

import racingcar.util.RandomGenerator;

public class Position {

    private static final int MOVE_FORWARD_STANDARD = 4;

    private final RandomGenerator randomGenerator;
    private int position;

    public Position(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
        position = 0;
    }

    public void move() {
        if (randomGenerator.generate() >= MOVE_FORWARD_STANDARD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "-".repeat(position);
    }
}
