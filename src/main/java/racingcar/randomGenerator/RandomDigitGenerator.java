package racingcar.randomGenerator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDigitGenerator implements RandomNumberGenerator {
    private static final RandomDigitGenerator INSTANCE = new RandomDigitGenerator();
    private static final int RANGE_START_INCLUSIVE = 1;
    private static final int RANGE_END_INCLUSIVE = 9;

    private RandomDigitGenerator() {
    }

    public static RandomDigitGenerator getInstance() {
        return INSTANCE;
    }

    public int generate() {
        return Randoms.pickNumberInRange(RANGE_START_INCLUSIVE, RANGE_END_INCLUSIVE);
    }
}
