package racingcar.domain.car.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    private static final Long MOVE_STEP = 1L;
    private static final int RANDOM_LOWER_BOUNDARY = 0;
    private static final int RANDOM_UPPER_BOUNDARY = 9;
    private static final int CAR_MOVEABLE_THRESHOLD = 4;

    @Override
    public long move(long position) {
        if (isMovable()) {
            position += MOVE_STEP;
        }
        return position;
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(RANDOM_LOWER_BOUNDARY, RANDOM_UPPER_BOUNDARY) >= CAR_MOVEABLE_THRESHOLD;
    }
}