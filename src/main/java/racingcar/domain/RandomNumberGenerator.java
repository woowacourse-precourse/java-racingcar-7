package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int RANGE_MIN = 0;
    private static final int RANGE_MAX = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX);
    }

}
