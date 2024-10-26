package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class GameUtil {
    public static Integer randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static Boolean isForward(Integer number) {
        return number >= 4;
    }
}
