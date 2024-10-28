package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumGenerator {

    private final static int MIN_NUMBER = 0;
    private final static char MAX_NUMBER = 9;

    public static int generateRandomNum() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

}
