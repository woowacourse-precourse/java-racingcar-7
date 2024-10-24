package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class MovingUtils {

    public static boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
