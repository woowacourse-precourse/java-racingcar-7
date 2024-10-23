package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_CONDITION_NUMBER = 4;
    private static final int MOVE_ONCE = 1;
    private static final int STOP = 0;

    @Override
    public int getPossibleMoveCount() {
        int pickedNumber = Randoms.pickNumberInRange(0, 9);
        if (pickedNumber >= MOVE_CONDITION_NUMBER) {
            return MOVE_ONCE;
        }

        return STOP;
    }
}
