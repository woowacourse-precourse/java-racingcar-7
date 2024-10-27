package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 기본 이동 전략을 구현한 클래스
 * 0-9 사이의 무작위 숫자를 생성하여 4 이상일 경우 이동
 */
public class DefaultMoveStrategy implements MoveStrategy {
    private static final int FORWARD_FLAG = 4; // 기준값 = 4

    /**
     * 자동차가 이동 여부 결정
     * @return 무작위 숫자가 FORWARD_FLAG(4) 이상이면 true
     */
    @Override
    public boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) >= FORWARD_FLAG;
    }
}
