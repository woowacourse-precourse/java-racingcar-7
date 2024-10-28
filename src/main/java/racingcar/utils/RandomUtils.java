package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {

    public static int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
