package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private RandomNumberGenerator() {
        throw new IllegalStateException("Util Class");
    }

    public static int generateRandomInteger() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
