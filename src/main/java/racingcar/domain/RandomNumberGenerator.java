package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MIN_INTEGER = 0;
    private static final int MAX_INTEGER = 9;

    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(MIN_INTEGER, MAX_INTEGER);
    }
}
