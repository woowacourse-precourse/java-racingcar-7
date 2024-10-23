package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public int make() {
        return Randoms.pickNumberInRange(Contants.MIN_RANDOM_NUMBER, Contants.MAX_RANDOM_NUMBER);
    }

    public boolean isNotLessThanFour(int num) {
        return num > Contants.COMPARISON_VALUE || num == Contants.COMPARISON_VALUE;
    }

    public boolean pick() {
        int random_num = make();
        return isNotLessThanFour(random_num);
    }
}
