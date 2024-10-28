package racingcar.util;

import racingcar.MoveStrategy;

public class TestMoveStrategies {

    public static class AlwaysMoveStrategy implements MoveStrategy {
        @Override
        public boolean shouldMove() {
            return true;
        }
    }

    public static class NeverMoveStrategy implements MoveStrategy {
        @Override
        public boolean shouldMove() {
            return false;
        }
    }
}
