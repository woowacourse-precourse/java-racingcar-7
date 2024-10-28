package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove() {
        int referenceNumber = Randoms.pickNumberInRange(0, 9);
        return referenceNumber > 3;
    }
}