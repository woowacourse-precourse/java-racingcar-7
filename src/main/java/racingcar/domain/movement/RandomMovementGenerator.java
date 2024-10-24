package racingcar.domain.movement;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementGenerator implements RandomMovement {

    public static final int RANDOM_MOVE_THRESHOLD = 4;
    public static final int MAX_MOVEMENT_VALUE = 9;
    public static final int MIN_MOVEMENT_VALUE = 0;

    @Override
    public boolean canGo() {
        return Randoms.pickNumberInRange(MIN_MOVEMENT_VALUE, MAX_MOVEMENT_VALUE) >= RANDOM_MOVE_THRESHOLD;
    }
}
