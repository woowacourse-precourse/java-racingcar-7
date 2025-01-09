package util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator implements NumberGenerator {

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;

    @Override
    public int makeNumber() {
        return Randoms.pickNumberInRange(RANDOM_START, RANDOM_END);
    }
}