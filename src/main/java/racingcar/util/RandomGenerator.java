package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator implements NumberGenerator {

    @Override
    public int generator() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
