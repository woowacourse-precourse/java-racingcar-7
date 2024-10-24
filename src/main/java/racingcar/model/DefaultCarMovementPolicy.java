package racingcar.model;

public class DefaultCarMovementPolicy implements CarMovementPolicy {

    private static final DefaultCarMovementPolicy instance = new DefaultCarMovementPolicy();
    private static final int CAR_MOVEMENT_VALUE = 4;
    
    private DefaultCarMovementPolicy() {
    }

    public static DefaultCarMovementPolicy getInstance() {
        return instance;
    }

    @Override
    public boolean isPossibleToMove(int movementValue) {
        return movementValue >= CAR_MOVEMENT_VALUE;
    }
}
