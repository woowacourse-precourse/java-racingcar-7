package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVABLE_THRESHOLD = 4;

    @Override
    public boolean isMovable() {
        int randomValue = Randoms.pickNumberInRange(0, 9); // pickNumberInRange() 메서드를 사용하여 0에서 9 사이의 값을 생성
        return randomValue >= MOVABLE_THRESHOLD; // 4 이상일 때만 이동 가능 상태를 반환
    }
}
