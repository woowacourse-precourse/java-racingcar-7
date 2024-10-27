package racingcar.model;

public enum ModelConstants {
    POSITION_INITIALIZE(0),
    CAN_MOVE_NUM(4),
    RANDOM_START_NUM(0),
    RANDOM_END_NUM(9);

    private int value;

    ModelConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
