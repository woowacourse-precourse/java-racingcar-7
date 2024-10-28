package racingcar.domain.strategy;

import static racingcar.domain.strategy.StrategyConstants.END_RANGE;
import static racingcar.domain.strategy.StrategyConstants.MOVE_THRESHOLD;
import static racingcar.domain.strategy.StrategyConstants.START_RANGE;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean isMovable() {
        return Randoms.pickNumberInRange(START_RANGE.getValue(), END_RANGE.getValue()) >= MOVE_THRESHOLD.getValue();
    }

}
