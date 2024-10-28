package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
    private static final int MIN_RANDOM_NUMBER_RANGE = 0;
    private static final int MAX_RANDOM_NUMBER_RANGE = 9;

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER_RANGE, MAX_RANDOM_NUMBER_RANGE);
    }
}
