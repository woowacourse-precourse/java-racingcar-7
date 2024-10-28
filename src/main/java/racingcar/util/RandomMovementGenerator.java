package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementGenerator {
    public static String create() {
        int r = Randoms.pickNumberInRange(0, 9);
        if (r >= 4) return "-";
        return "";
    }
}
