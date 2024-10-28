package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int START_INCLUSIVE = 0;

    private final int endInclusive;

    public RandomNumberGenerator(int endInclusive) {
        this.endInclusive = endInclusive;
    }

    public int generate() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, endInclusive);
    }
}
