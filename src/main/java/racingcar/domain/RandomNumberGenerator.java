package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static final int RANDOM_MIN = 0;
    public static final int RANDOM_MAX = 9;

    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }
}
