package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;

    public static int pickNumberInRange() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
