package racingcar.util.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class IntegerGenerator implements Generator<Integer> {
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 0;

    @Override
    public Integer generate() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
