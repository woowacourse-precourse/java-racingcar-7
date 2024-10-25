package racingcar.global.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static RandomNumberGenerator instance;

    public static RandomNumberGenerator getInstance() {
        if (instance == null) {
            instance = new RandomNumberGenerator();
        }
        return instance;
    }

    public int generator() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
