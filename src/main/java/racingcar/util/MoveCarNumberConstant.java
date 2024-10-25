package racingcar.util;

public enum MoveCarNumberConstant {

    CAR_MOVE_CONDITION(4),
    RANDOM_NUMBER_START_WITH(0),
    RANDOM_NUMBER_END_WITH(9),
    EXECUTION_RANGE_MAX_VALUE(1_000),
    EXECUTION_RANGE_MIN_VALUE(1),
    CAR_IS_NOT_STARTED_YET(0);

    private final int value;

    MoveCarNumberConstant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
