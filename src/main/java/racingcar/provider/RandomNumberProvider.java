package racingcar.provider;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberProvider implements NumberProvider {

    private static final int RANDOM_NUMBER_RANGE_OF_MIN = 1;
    private static final int RANDOM_NUMBER_RANGE_OF_MAX = 9;

    @Override
    public int getNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_OF_MIN, RANDOM_NUMBER_RANGE_OF_MAX);
    }

}
