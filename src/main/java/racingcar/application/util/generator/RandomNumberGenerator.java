package racingcar.application.util.generator;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberGenerator {

    private static final int START_RANGE = 0;
    private static final int END_RANGE = 9;

    private RandomNumberGenerator() {}

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(START_RANGE, END_RANGE);
    }

}
