package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy{
    private static final int MOVE_CONDITION_NUMBER = 4;

    @Override
    public boolean canMove() {
        int pickedNumber = Randoms.pickNumberInRange(0, 9);
        return pickedNumber >= MOVE_CONDITION_NUMBER;
    }
}
