package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
    private int MAX_RANDOM_NUMBER_RANGE = 9;

    public Number() {

    }

    public int getRandomNumber() {
        int num = Randoms.pickNumberInRange(0, MAX_RANDOM_NUMBER_RANGE);
        return num;
    }
}
