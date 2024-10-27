package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements RandomGenerator {
    private final static int MIN_VALUE = 0;
    private final static int MAX_VALUE = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }
}
