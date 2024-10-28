package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean canMove() {
        int randomValue = Randoms.pickNumberInRange(MIN,MAX);

        return randomValue >= MOVE_THRESHOLD;
    }

}
