package racingcar.support;

import racingcar.strategy.MovingStrategy;

public class SequentialMovingStrategy implements MovingStrategy {
    private final boolean[] sequence;
    private int currentIndex = 0;

    private SequentialMovingStrategy(boolean... sequence) {
        this.sequence = sequence;
    }

    public static MovingStrategy sequence(boolean... moves) {
        return new SequentialMovingStrategy(moves);
    }

    @Override
    public boolean shouldMove() {
        if (currentIndex >= sequence.length) {
            throw new IllegalStateException();
        }

        return sequence[currentIndex++];
    }
}
