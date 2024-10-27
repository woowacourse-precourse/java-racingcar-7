package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGeneratorImpl implements NumberGenerator {
    
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
