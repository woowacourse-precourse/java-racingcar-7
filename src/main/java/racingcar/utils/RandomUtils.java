package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {
    private static final int LOWER_BOUND = 1;

    public boolean isProbabilityHit(int upperBound, int threshold) {
        if (threshold < LOWER_BOUND || threshold > upperBound) {
            throw new IllegalArgumentException(ConstantMessage.INVALID_RANGE_EXCEPTION);
        }
        return Randoms.pickNumberInRange(LOWER_BOUND, upperBound) <= threshold;
    }
}
