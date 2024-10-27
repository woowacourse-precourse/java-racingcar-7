package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementStrategy implements MovementStrategy {
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    @Override
    public boolean moveable() {
        return makeRandomNumber() >= MOVE_THRESHOLD;
    }

    protected int makeRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }

}
