package racingcar.domain.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private final int RANDOM_START;
    private final int RANDOM_END;

    public RandomNumberGenerator(final int start, final int end) {
        this.RANDOM_START = start;
        this.RANDOM_END = end;
    }

    public int pick() {
        return Randoms.pickNumberInRange(RANDOM_START, RANDOM_END);
    }
}
