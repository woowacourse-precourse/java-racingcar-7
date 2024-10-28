package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public static int getRandomNumberInRange(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
