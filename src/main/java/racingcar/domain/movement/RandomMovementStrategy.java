package racingcar.domain.movement;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementStrategy implements MovementStrategy {
    private static final int FORWARD_THRESHOLD = 4;

    @Override
    public boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) >= FORWARD_THRESHOLD;
    }
}
