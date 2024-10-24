package racingcar.util;

public enum ConstNumber {
    CARNAME_MAX_LENGTH(5),
    EXECUTION_RANGE_MAX_VALUE(1_000),
    EXECUTION_RANGE_MIN_VALUE(1);

    private final int value;

    private ConstNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
