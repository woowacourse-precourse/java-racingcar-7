package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Conditioner {
    public static boolean setCondition() {
        int num = Randoms.pickNumberInRange(0, 9);
        if (num >= 4) {
            return true;
        }
        return false;
    }
}
