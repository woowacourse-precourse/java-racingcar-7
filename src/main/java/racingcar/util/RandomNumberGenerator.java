package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int RANDOM_NUMBER_START = 0;
    private static final int RANDOM_NUMBER_END = 9;

    public static int move(){
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
    }
}
