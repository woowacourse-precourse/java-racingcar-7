package racingcar.common;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private static final int MIN_NUMBER_RANGE = 0;
    private static final int MAX_NUMBER_RANGE = 9;

    public static int pick() {
        return Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
    }
}
