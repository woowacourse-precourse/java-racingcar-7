package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private final int startValue;
    private final int endValue;
    public NumberGenerator(int startValue, int endValue) {
        this.startValue = startValue;
        this.endValue = endValue;
    }

    public int getRandomNumber(){
        return Randoms.pickNumberInRange(startValue, endValue);
    }
}
