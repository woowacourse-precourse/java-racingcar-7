package racingcar.integer_generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDigitGenerator implements IntegerGenerator {

    @Override
    public Integer generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
