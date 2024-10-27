package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    final static int START = 0;
    final static int END = 9;

    public static int randomNumber() {
        int number = Randoms.pickNumberInRange(START, END);
        return number;
    }
}
