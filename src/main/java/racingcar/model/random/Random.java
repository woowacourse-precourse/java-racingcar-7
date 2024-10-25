package racingcar.model.random;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    public static boolean randomBoolean() {
        final int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }
}
