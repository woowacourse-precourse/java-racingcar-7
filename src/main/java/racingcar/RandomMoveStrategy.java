package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean canMove() {
        return isMoveAllowed(getRandomNumber());
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9); // 0에서 9까지의 랜덤 숫자 추출
    }

    private boolean isMoveAllowed(int randomNumber) {
        return randomNumber >= MOVE_THRESHOLD; // 이동 허용 여부 판단
    }
}