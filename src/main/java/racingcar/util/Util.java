package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {
    private static final int GO = 4;

    public static boolean isCanGo() {
        return RandomNumber() >= GO;
    }
    public static int RandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
