package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements RandomGenerator {

    @Override
    public int pickNumberInRange(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
