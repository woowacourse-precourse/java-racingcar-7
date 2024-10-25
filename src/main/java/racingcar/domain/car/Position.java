package racingcar.domain.car;

import racingcar.util.RandomUtil;

public class Position {

    private static final int INIT_POSITION = 0;
    private static final int MOVE_STANDARD = 4;
    private static final int DEFAULT_MOVE_DISTANCE = 1;

    private int position;

    public Position() {
        position = INIT_POSITION;
    }

    public Position(int position) {
        this.position = position;
    }

    public int get() {
        return position;
    }

    public void playRound() {
        move(RandomUtil.pickCarNumber());
    }

    protected void move(int carNumber) {
        if (carNumber >= MOVE_STANDARD) {
            position += DEFAULT_MOVE_DISTANCE;
        }
    }
}
