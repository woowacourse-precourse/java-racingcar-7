package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MovementCondition {
    public static String isMovementAllowed() {
        return checkWithRandom();
    }

    private static String checkWithRandom() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return "move";
        }
        return "stop";
    }
}
