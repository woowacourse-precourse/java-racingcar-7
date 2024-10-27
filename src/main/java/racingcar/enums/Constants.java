package racingcar.enums;

public enum Constants {

    RANGE_LOWER_BOUND(0),
    RANGE_UPPER_BOUND(9),
    NAME_LENGTH_LIMIT(5),
    MOVE_CONDITION(4),
    CAR_COUNT_MINIMUM(1),
    ;

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
