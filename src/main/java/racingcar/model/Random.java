package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    public static int getRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
