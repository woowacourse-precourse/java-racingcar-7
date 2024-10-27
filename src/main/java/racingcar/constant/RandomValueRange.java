package racingcar.constant;

public enum RandomValueRange {

    MIN_VALUE(0), MAX_VALUE(9);

    private final int value;

    RandomValueRange(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
