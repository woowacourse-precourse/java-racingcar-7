package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private final static int START = 0;
    private final static int END = 9;

    public static int generateNumber() {
        return Randoms.pickNumberInRange(START, END);
    }
}
