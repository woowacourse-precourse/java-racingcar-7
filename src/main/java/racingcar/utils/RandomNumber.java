package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private RandomNumber() {
    }

    public static int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
