package racingcar.support.random;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomIntegerGenerator implements RandomNumberGenerator<Integer> {

    private final int randomNumberStartInclusive;
    private final int randomNumberEndInclusive;

    public RandomIntegerGenerator(final int randomNumberStartInclusive, final int randomNumberEndInclusive) {
        this.randomNumberStartInclusive = randomNumberStartInclusive;
        this.randomNumberEndInclusive = randomNumberEndInclusive;
    }

    @Override
    public Integer pickNumber() {
        return Randoms.pickNumberInRange(randomNumberStartInclusive, randomNumberEndInclusive);
    }
}
