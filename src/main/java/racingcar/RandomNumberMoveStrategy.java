package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberMoveStrategy implements MoveStrategy {

    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_CONDITION;
    }
}
