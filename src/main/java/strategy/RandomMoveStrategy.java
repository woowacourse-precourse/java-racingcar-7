package strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean isPossibleToMove() {
        return Randoms.pickNumberInRange(0,9) >= 4;
    }
}
