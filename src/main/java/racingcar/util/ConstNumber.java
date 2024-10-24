package racingcar.util;

public enum ConstNumber {
    CAR_NAME_MAX_LENGTH(5),
    PRIME_CAR_DISTANCE(0),
    CAR_MOVE_CONDITION(4),
    RANDOM_NUMBER_START_WITH(0),
    RANDOM_NUMBER_END_WITH(9),
    EXECUTION_RANGE_MAX_VALUE(1_000),
    EXECUTION_RANGE_MIN_VALUE(1),
    CAR_IS_NOT_STARTED_YET(0);

    private final int value;

    ConstNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
