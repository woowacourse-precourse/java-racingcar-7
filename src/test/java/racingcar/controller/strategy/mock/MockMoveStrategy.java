package racingcar.controller.strategy.mock;

import racingcar.controller.strategy.MoveStrategy;

public class MockMoveStrategy implements MoveStrategy {

    private final boolean movable;

    public MockMoveStrategy(final boolean movable) {
        this.movable = movable;
    }

    @Override
    public boolean isMovable() {
        return movable;
    }
}
