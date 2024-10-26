package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }
}
