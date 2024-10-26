package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomIntegerGenerator implements IntegerGenerator {

    @Override
    public Integer generate(Number start, Number end) {
        return Randoms.pickNumberInRange((int) start, (int) end);
    }
}
