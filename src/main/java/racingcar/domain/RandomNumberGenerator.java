package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int START_INCLUSIVE = 0;
    private static final int BOUNDARY_OFFSET = 1;

    private final int endInclusive;

    public RandomNumberGenerator(int endInclusive) {
        this.endInclusive = endInclusive;
    }

    public int generate() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, endInclusive + BOUNDARY_OFFSET);
    }
}
