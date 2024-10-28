package racingcar.util;

public class FixedMovementStrategy implements MovementStrategy {
    private static final int MOVE_THRESHOLD = 4;
    private final int fixedValue;

    public FixedMovementStrategy(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public boolean canMove() {
        return fixedValue >= MOVE_THRESHOLD;
    }
}
