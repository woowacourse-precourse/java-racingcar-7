package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private final int minNumber;
    private final int maxNumber;

    public NumberGenerator(int minNumber, int maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    public int pickOne() {
        return Randoms.pickNumberInRange(minNumber, maxNumber);
    }
}
