package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumUtil {
    private static final int RANDOM_RANGE_START = 0;
    private static final int RANDOM_RANGE_END = 9;

    public static int getRandomNum() {
        return Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END);
    }
}
