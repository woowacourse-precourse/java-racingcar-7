package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private final int MIN_RANDOM_NUMBER = 0;
    private final int MAX_RANDOM_NUMBER = 9;

    public int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
