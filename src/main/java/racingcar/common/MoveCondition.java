package racingcar.common;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveCondition {

    private static final int DEFAULT = 4;

    public static boolean isMoveable() {
        return Randoms.pickNumberInRange(0, 9) >= DEFAULT;
    }
}
