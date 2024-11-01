package racingcar.message;

public enum CarConstant {
    MAX_NAME_LENGTH(5),
    INITIAL_POSITION(0);

    private int value;

    CarConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
