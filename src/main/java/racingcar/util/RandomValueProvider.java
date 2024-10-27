package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constant.RandomValueRange.MAX_VALUE;
import static racingcar.constant.RandomValueRange.MIN_VALUE;

public class RandomValueProvider {
    public int provideRandomValue() {
        return Randoms.pickNumberInRange(MIN_VALUE.value(), MAX_VALUE.value());
    }
}
