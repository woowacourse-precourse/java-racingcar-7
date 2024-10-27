package racingcar.model.valuegenerator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomValueGenerator implements ValueGenerator {

    @Override
    public int getValue() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
