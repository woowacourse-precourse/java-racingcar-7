package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public static int makeRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
