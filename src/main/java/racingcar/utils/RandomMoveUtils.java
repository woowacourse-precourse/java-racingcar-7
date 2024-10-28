package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveUtils {

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean isMoving(int randomNumber) {
        return randomNumber >= 4;
    }
}
