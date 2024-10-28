package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * NumberGenerator 인터페이스를 구현한 무작위 수 생성기 클래스입니다. 자동차의 전진 여부를 결정하기 위해 0부터 9까지의 무작위 정수를 생성합니다.
 */
public class RandomNumberGenerator {

    /**
     * 0부터 9까지의 무작위 정수를 생성하여 반환합니다.
     *
     * @return 0 이상 10 미만의 무작위 정수
     */
    public int generate() {
        return Randoms.pickNumberInRange(0, 9); // 0부터 9까지의 정수 중 하나를 반환
    }
}
