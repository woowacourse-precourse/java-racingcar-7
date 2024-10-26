package racingcar.model.policy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveCondition implements MoveConditionPolicy {

    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public int pickNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }

    @Override
    public boolean isMovable() {
        return pickNumber() >= MOVE_THRESHOLD;
    }
}
