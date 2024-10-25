package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberCreator {
    private static final Integer START_RANDOM_NUMBER = 0;
    private static final Integer END_RANDOM_NUMBER = 9;

    public static Integer getRandomNumber() {
        return Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
    }
}
