package racingcar.domain.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static Integer randomNumberGenerator(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
