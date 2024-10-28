package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private final int MINIMUM_NUMBER = 0;
    private final int MAXIMUM_NUMBER = 9;

    public int generate() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }
}
