package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {

    private static final int MIN = 0;
    private static final int MAX = 9;

    public static int getRandomValue() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
