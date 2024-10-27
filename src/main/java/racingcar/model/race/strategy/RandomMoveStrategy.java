package racingcar.model.race.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy{

    private static final int RANDOM_RANGE_START = 0;
    private static final int RANDOM_RANGE_END = 9;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean canMove() {
        return Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END) >= MOVE_THRESHOLD;
    }
}
