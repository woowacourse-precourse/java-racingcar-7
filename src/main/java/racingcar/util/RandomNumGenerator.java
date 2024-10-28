package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumGenerator {

    public static int generateRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
