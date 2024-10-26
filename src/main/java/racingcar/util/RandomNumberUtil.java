package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberUtil {
    private static final int START_NUM = 0;
    private static final int END_NUM = 9;

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(START_NUM, END_NUM);
    }
}
