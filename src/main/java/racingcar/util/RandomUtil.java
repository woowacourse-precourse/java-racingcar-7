package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    private static final int CAR_NUMBER_START_INCLUSIVE = 0;
    private static final int CAR_NUMBER_END_INCLUSIVE = 9;

    private RandomUtil() {
    }

    public static int pickCarNumber() {
        return pickNumberInRange(CAR_NUMBER_START_INCLUSIVE, CAR_NUMBER_END_INCLUSIVE);
    }

    private static int pickNumberInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
