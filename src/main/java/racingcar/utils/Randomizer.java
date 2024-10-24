package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class Randomizer {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    public static int getRandomValue() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }
}
