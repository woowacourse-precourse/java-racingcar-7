package racingcar.model;

public class DefaultCarMovementPolicy implements CarMovementPolicy {

    private static final int CAR_MOVEMENT_VALUE = 4;

    @Override
    public boolean isPossibleToMove(int movementValue) {
        return movementValue >= CAR_MOVEMENT_VALUE;
    }
}
