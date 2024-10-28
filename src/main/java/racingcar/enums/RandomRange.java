package racingcar.enums;

public enum RandomRange {
    MIN(0),
    MAX(9);

    private final int value;

    RandomRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
