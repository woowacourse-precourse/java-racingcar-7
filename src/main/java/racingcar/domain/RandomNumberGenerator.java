package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MIN = 0;
    private static final int MAX = 9;

    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
