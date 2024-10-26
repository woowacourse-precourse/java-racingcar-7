package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    private static final int UNDER_BOUND = 0;
    private static final int OVER_BOUND = 9;

    public static int pickRandom() {
        return Randoms.pickNumberInRange(UNDER_BOUND, OVER_BOUND);
    }
}
