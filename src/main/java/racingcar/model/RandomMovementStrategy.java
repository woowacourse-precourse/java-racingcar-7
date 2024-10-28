package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementStrategy implements MovementStrategy{
    @Override
    public boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
