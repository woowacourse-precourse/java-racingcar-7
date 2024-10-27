package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementStrategy implements MovementStrategy {
    private static final int MOVE_THRESHOLD = 4;
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 9;

    @Override
    public boolean canMove() {
        int randomValue = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
        return randomValue >= MOVE_THRESHOLD;
    }
}