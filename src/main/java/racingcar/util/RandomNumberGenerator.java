package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberGenerator {

    public static int generate(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

}
