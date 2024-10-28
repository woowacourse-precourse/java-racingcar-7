package racingcar.common;

public enum Ranges {
    MAX_NAME_LENGTH(5),
    MAX_CARS(100),
    MIN_ROUNDS(1),
    MAX_ROUNDS(5000);

    private final int value;

    Ranges(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
