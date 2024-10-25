package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {
    public boolean isProbabilityHit(int upperBound, int threshold) {
        return Randoms.pickNumberInRange(1, upperBound) <= threshold;
    }
}
