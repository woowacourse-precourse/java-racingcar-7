package racingcar.model.valuegenerator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomValueGenerator implements ValueGenerator {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;

    @Override
    public int getValue() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }
}
