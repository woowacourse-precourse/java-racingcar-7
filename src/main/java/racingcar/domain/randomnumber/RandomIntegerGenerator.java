package racingcar.domain.randomnumber;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomIntegerGenerator implements RandomNumberGenerator<Integer> {

    private final int lowerBound;
    private final int upperBound;

    public RandomIntegerGenerator(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public Integer pickNumber() {
        return Randoms.pickNumberInRange(lowerBound, upperBound);
    }
}
