package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class GameUtil {
    public static Integer getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static Boolean isForward(Integer number) {
        return number >= 4;
    }
}
