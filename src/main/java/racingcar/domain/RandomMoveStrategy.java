package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int RANGE_MIN_VALUE = 0;
    private static final int RANGE_MAX_VALUE = 9;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean isMovable() {
        return Randoms.pickNumberInRange(RANGE_MIN_VALUE, RANGE_MAX_VALUE) >= MOVE_THRESHOLD;
    }
}
