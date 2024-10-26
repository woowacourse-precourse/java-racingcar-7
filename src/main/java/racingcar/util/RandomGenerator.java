package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    public static int generateRandomNumber() {
        int MIN_RANDOM_VALUE = 0;
        int MAX_RANDOM_VALUE = 9;

        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
    }

}
