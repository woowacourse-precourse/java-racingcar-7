package racingcar.utils;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class RandomNumberGenerator {
    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;

    private RandomNumberGenerator() {}

    public static int generateRandomNumber() {
        return pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }
}
