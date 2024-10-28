package racingcar.enums;

public enum Limits {
    DEFAULT(0),
    MAX(5),
    MIN_FORWARD_VALUE(4);

    private final int value;

    Limits(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
