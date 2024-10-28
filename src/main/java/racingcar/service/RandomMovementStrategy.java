package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementStrategy  {
    private static final int MOVEMENT_THRESHOLD = 4;

    public boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) >= MOVEMENT_THRESHOLD;
    }
}
