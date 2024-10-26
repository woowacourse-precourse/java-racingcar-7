package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private static final RandomNumberGenerator INSTANCE = new RandomNumberGenerator();

    private RandomNumberGenerator() {
    }

    public static RandomNumberGenerator getInstance() {
        return INSTANCE;
    }

    @Override
    public int generateNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

}
