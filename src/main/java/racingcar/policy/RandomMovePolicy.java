package racingcar.policy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovePolicy implements MovePolicy {
    private final static Integer MIN_RANDOM_VALUE = 0;
    private final static Integer MAX_RANDOM_VALUE = 9;
    private final static Integer MOVE_THRESHOLD = 4;

    public boolean canMove() {
        int value = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        return value >= MOVE_THRESHOLD;
    }
}
