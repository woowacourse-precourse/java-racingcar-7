package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class WoowaRandomNumberGenerator implements NumberGenerator {
    private final int MINIMUM_RANDOM_NUMBER_RANGE = 0;
    private final int MAXIMUM_RANDOM_NUMBER_RANGE = 9;

    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER_RANGE, MAXIMUM_RANDOM_NUMBER_RANGE);
    }
}
