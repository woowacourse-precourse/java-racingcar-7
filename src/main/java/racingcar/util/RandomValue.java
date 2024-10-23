package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomValue {

    public static int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
