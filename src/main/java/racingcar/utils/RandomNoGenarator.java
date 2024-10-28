package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNoGenarator {

    private RandomNoGenarator() {
    }

    public static int getRandomNo() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
