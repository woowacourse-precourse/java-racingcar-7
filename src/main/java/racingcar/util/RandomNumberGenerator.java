package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private RandomNumberGenerator() {}

    public static int generate() {
        return Randoms.pickNumberInRange(0, 9); // 0과 9 사이의 임의의 값 반환
    }
}
