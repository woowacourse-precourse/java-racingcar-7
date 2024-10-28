package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 랜덤 숫자를 생성하는 클래스
 */
public class RandomNumberGenerator {
    private static final int MIN = 0;
    private static final int MAX = 9;

    /**
     * 0과 9사이에 랜덤 숫자를 생성합니다.
     *
     * @return 생성된 랜덤 숫자 (0~9)
     */
    public static int generate() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
