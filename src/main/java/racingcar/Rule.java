package racingcar;

public class Rule {
    private static final int MOVING_THRESHOLD = 4;

    public boolean canMove(int number) {
        return number >= MOVING_THRESHOLD;
    }
}
