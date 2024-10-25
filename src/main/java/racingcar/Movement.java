package racingcar;

public class Movement {
    private final static int MOVING_FORWARD_POINT = 4;
    private RandomGenerator randomGenerator;

    public Movement(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public boolean moveForward() {
        int random = randomGenerator.pickNumberInRange(0, 9);
        return random >= MOVING_FORWARD_POINT;
    }
}
