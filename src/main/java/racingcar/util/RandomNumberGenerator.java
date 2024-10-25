package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements RandomGenerator {
    public int pickNumberInRange(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }
}
