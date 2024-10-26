package racingcar.strategy.move;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementStrategy implements MovementStrategy {

    @Override
    public boolean shouldMove() {
        int rand = Randoms.pickNumberInRange(0, 9);
        return rand >= 4;
    }
}