package racingcar.support;

import racingcar.strategy.MovingStrategy;

public class NeverMovingStrategy implements MovingStrategy {
    @Override
    public boolean shouldMove() {
        return false;
    }
}
