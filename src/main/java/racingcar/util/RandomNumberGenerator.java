package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private final static int RANDOM_NUMBER_MIN = 0;
    private final static int RANDOM_NUMBER_MAX = 9;

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }
}
