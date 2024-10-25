package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public final class Random {
    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
