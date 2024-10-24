package racingcar.domain.movement;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementGenerator implements RandomMovement {

    public static final Integer RANDOM_MOVE_THRESHOLD = 4;
    public static final Integer MAX_MOVEMENT_VALUE = 9;
    public static final Integer MIN_MOVEMENT_VALUE = 0;

    @Override
    public boolean canGo() {
        return Randoms.pickNumberInRange(MIN_MOVEMENT_VALUE, MAX_MOVEMENT_VALUE) >= RANDOM_MOVE_THRESHOLD;
    }
}
