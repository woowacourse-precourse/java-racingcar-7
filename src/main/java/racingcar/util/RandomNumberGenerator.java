package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public static int generateSingleNumberBetweenZeroAndNine() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
