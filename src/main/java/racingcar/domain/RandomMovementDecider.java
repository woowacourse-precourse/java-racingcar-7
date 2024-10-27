package racingcar.domain;

import static racingcar.constants.Constraints.MAX_RANDOM_NUMBER;
import static racingcar.constants.Constraints.MIN_MOVEMENT_NUMBER;
import static racingcar.constants.Constraints.MIN_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementDecider implements MovementDecider {
    @Override
    public boolean isMoveable() {
        int number = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        if (number < MIN_MOVEMENT_NUMBER)
            return false;

        return true;
    }
}
