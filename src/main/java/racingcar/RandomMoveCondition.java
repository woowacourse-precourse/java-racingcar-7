package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveCondition implements MoveCondition {

    private static final int standard_number = 4;

    @Override
    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= standard_number;
    }
}
