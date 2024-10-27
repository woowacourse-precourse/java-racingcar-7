package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovement implements Movement {
    private static final int MINIMUM_RANDOM_VALUE = 0;
    private static final int MAXIMUM_RANDOM_VALUE = 9;
    private static final int MOVEMENT_THRESHOLD = 4;

    public boolean isAbleToMove() {
        return getRandomValue() >= MOVEMENT_THRESHOLD;
    }

    private int getRandomValue() {
        return Randoms.pickNumberInRange(MINIMUM_RANDOM_VALUE, MAXIMUM_RANDOM_VALUE);
    }
}
