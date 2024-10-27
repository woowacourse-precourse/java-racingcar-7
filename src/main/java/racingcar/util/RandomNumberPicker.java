package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberPicker {

    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 9;
    
    public static int pick() {
        return Randoms.pickNumberInRange(MINIMUM, MAXIMUM);
    }
}
