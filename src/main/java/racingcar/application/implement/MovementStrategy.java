package racingcar.application.implement;

import static racingcar.common.constant.RacingCarConstant.MAX_RANDOM_BOUND;
import static racingcar.common.constant.RacingCarConstant.MIN_RANDOM_BOUND;
import static racingcar.common.constant.RacingCarConstant.MOVE_THRESHOLD;

import camp.nextstep.edu.missionutils.Randoms;

public class MovementStrategy {

    public boolean isMovable() {
        int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_BOUND, MAX_RANDOM_BOUND);
        return randomValue >= MOVE_THRESHOLD;
    }
}
