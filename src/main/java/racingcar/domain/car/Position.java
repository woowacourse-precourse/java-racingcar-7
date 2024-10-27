package racingcar.domain.car;

import racingcar.util.RandomUtil;

public class Position {

    private static final int DEFAULT_POSITION = 0;
    private static final int MOVE_STANDARD = 4;
    private static final int DEFAULT_MOVE_DISTANCE = 1;

    private int position;
    private final RandomUtil randomUtil;

    public Position(RandomUtil randomUtil) {
        this(randomUtil, DEFAULT_POSITION);
        // this.randomUtil = randomUtil;
        // position = DEFAULT_POSITION;
    }

    public Position(RandomUtil randomUtil, int position) {
        this.randomUtil = randomUtil;
        this.position = position;
    }

    public int get() {
        return position;
    }

    public void playRound() {
        if (randomUtil.pickCarNumber() >= MOVE_STANDARD) {
            position += DEFAULT_MOVE_DISTANCE;
        }
    }
}
