package racingcar.race;

import racingcar.util.RandomGenerator;

public class Movement {
    private final static int MOVING_FORWARD_POINT = 4;
    private final static int START_AT = 0;
    private final static int END_AT = 9;
    private final RandomGenerator randomGenerator;

    public Movement(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public boolean moveForward() {
        int random = randomGenerator.pickNumberInRange(START_AT, END_AT);
        return random >= MOVING_FORWARD_POINT;
    }
}
