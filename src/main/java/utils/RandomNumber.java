package utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private RandomNumber() {
    }

    public static int getNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
