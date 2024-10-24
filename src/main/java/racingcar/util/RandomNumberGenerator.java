package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private final int startInclusive;
    private final int endInclusive;
    private static final int DEFAULT_START_INCLUSIVE = 0;
    private static final int DEFAULT_END_INCLUSIVE = 9;

    public RandomNumberGenerator() {
        this(DEFAULT_START_INCLUSIVE, DEFAULT_END_INCLUSIVE);
    }

    public RandomNumberGenerator(int startInclusive, int endInclusive) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
