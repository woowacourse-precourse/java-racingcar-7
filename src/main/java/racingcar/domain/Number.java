package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
    private static final int MAX_RANDOM_NUMBER_RANGE = 9;

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, MAX_RANDOM_NUMBER_RANGE);
    }
}
