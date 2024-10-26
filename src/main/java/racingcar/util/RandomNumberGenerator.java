package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {
        // 인스턴스화 방지
    }

    public static int generate(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}