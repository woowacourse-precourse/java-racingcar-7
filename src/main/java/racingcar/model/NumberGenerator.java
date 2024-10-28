package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private final int START_VALUE;
    private final int END_VALUE;
    public NumberGenerator(int startValue, int endValue) {
        this.START_VALUE = startValue;
        this.END_VALUE = endValue;
    }

    public int getRandomNumber(){
        return Randoms.pickNumberInRange(START_VALUE, END_VALUE);
    }
}
