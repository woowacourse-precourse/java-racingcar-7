package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 10;

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }
}
