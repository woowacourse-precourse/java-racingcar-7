package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private static int getNumberInRange() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean isMoreThanFour() {
        return getNumberInRange() >= 4;
    }
}
