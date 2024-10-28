package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveCondition implements MoveCondition {

    private static final int STANDARD_NUMBER = 4;

    @Override
    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= STANDARD_NUMBER;
    }
}
