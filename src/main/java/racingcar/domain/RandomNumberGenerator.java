package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * RandomNumberGenerator 클래스는 NumberGenerator 인터페이스를 구현하여,
 * - 지정된 범위의 난수를 생성하는 역할을 한다.
 */
public class RandomNumberGenerator implements NumberGenerator {

    private static final int RANDOM_LOWER_INCLUSIVE = 0;   // 난수 생성 범위의 하한값
    private static final int RANDOM_UPPER_INCLUSIVE = 9;   // 난수 생성 범위의 상한값

    /**
     * 난수를 생성하여 반환한다.
     * - 범위: 0 ~ 9
     */
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
    }
}
