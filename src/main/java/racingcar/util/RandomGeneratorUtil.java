package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGeneratorUtil {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    public static Integer getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
