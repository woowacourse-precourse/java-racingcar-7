package racingcar.domain.car;

import racingcar.util.RandomUtil;

public class Position {

    private static final int DEFAULT_POSITION = 0;
    private static final int MOVE_STANDARD = 4;
    private static final int DEFAULT_MOVE_DISTANCE = 1;

    private int position;
    private final RandomUtil randomUtil;

    public Position(RandomUtil randomUtil) {
        this(DEFAULT_POSITION,randomUtil);
    }

    public Position(int position, RandomUtil randomUtil) {
        this.position = position;
        this.randomUtil = randomUtil;
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
