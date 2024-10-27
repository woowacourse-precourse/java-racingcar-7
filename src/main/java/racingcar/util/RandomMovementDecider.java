package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementDecider {
    private static final int THRESHOLD = 4;

    public static boolean decide() {
        return Randoms.pickNumberInRange(0, 9) >= THRESHOLD;
    }
}
