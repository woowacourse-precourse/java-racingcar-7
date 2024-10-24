package racingcar.enums;

public enum NameLength {
    MIN_LENGTH(1),
    MAX_LENGTH(5);

    private final int value;

    NameLength(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
