package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    public static final int RANDOM_MIN = 0;
    public static final int RANDOM_MAX = 9;

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }
}
