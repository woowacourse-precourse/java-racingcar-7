package racingcar.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean isAllowedToAdvance() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
