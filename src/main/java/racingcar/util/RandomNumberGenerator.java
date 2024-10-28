package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public abstract class RandomNumberGenerator {

    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;

    private RandomNumberGenerator() {
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }
}
