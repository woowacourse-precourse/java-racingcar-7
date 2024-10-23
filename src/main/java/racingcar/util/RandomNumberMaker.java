package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberMaker {

    private final static int MIN = 0;
    private final static int MAX = 9;

    public static int randomNumber() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
