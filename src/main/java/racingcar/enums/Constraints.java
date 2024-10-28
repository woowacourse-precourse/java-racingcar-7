package racingcar.enums;

public enum Constraints {
    MAX_CAR_NAME_LENGTH(5),
    MOVE_CONDITION(4),
    MIN_MOVE_RANGE(0),
    MAX_MOVE_RANGE(9);

    private final int value;

    Constraints(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
