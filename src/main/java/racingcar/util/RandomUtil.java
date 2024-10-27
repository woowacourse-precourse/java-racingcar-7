package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;

    public static int pickRandom() {
        return Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND);
    }
}
