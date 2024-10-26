package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomUtil {

    private RandomUtil() {}

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
