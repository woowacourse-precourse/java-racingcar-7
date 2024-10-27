package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandNumGenerator {
    private static final int RAND_MIN = 0;
    private static final int RAND_MAX = 9;
    private static final int MIN_NUM_FOR_MOVE = 4;

    public boolean isRandNumGreaterThanOrEqualToCriterion() {
        int randNum = Randoms.pickNumberInRange(RAND_MIN, RAND_MAX);
        return randNum >= MIN_NUM_FOR_MOVE;
    }
}
