package racingcar.domain.movement;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementGenerator implements RandomMovement {

    public static final Integer RANDOM_MOVE_THRESHOLD = 4;

    @Override
    public boolean randomMove() {
        return Randoms.pickNumberInRange(0, 9) >= RANDOM_MOVE_THRESHOLD;
    }
}
