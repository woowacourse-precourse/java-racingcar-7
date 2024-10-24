package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {

    public static boolean isMovable() {
        return Randoms.pickNumberInRange(0,9) >= 4;
    }
}
