package racingcar.medel;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMover {
    private static final int MOVE_THRESHOLD = 4;

    // 테스트 코드를 위해 매개변수로 값을 받도록 구현
    public boolean canMove(int randomValue) {
        return randomValue >= MOVE_THRESHOLD;
    }

    public boolean canMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return canMove(randomValue);
    }
}
