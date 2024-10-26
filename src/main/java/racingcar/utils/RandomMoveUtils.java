package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveUtils {
    public static boolean isMoving() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= 4;
    }
}
