package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGeneratorImpI implements RandomGenerator{
    @Override
    public int pickNumber(int bound) {
        return Randoms.pickNumberInRange(0,bound);
    }
}
