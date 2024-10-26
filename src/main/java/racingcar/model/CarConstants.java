package racingcar.model;

public enum CarConstants {
    CAN_MOVE_NUM(4),
    RANDOM_START_NUM(0),
    RANDOM_END_NUM(9);

    private int value;

    CarConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
