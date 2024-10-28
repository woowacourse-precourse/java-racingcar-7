package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;
    private static final int MOVE_STANDARD = 4;

    @Override
    public boolean movable() {
        return pickRandom() >= MOVE_STANDARD;
    }

    private int pickRandom() {
        return Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND);
    }
}
