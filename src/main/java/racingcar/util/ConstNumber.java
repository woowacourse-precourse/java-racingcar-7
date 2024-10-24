package racingcar.util;

public enum ConstNumber {
    CARNAME_MAX_LENGTH(5),
    EXECUTION_RANGE_MAX_VALUE(1_000),
    EXECUTION_RANGE_MIN_VALUE(1);

    private final long value;

    private ConstNumber(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
