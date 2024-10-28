package racingcar.enums;

public enum Constraints {
    MAX_CAR_NAME_LENGTH(5),
    MOVE_DETERMINANT(4),
    MIN_MOVE_RANDOM_NUMBER_RANGE(0),
    MAX_MOVE_RANDOM_NUMBER_RANGE(9);

    private int value;

    Constraints(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
