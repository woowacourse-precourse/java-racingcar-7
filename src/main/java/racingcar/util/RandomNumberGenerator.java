package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private RandomNumberGenerator() {
        throw new IllegalStateException("Util Class");
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
