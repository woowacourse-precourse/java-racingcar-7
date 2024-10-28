package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomGenerator implements RandomGenerator {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }
}