package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class MovementDecider {
    private static final int DEFAULT_THRESHOLD = 4;

    public static boolean tryMove() {
        return Randoms.pickNumberInRange(0, 9) >= DEFAULT_THRESHOLD;
    }
}
