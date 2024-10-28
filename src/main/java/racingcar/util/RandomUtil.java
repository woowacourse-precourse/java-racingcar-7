package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    public static final int RANDOM_MIN_RANGE = 0;
    public static final int RANDOM_MAX_RANGE = 9;

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN_RANGE, RANDOM_MAX_RANGE);
    }
}
