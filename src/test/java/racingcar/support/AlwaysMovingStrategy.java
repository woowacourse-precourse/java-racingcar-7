package racingcar.support;

import racingcar.strategy.MovingStrategy;

public class AlwaysMovingStrategy implements MovingStrategy {
    @Override
    public boolean shouldMove() {
        return true;
    }
}
