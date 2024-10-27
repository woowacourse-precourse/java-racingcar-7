package racingcar.Model;

public enum Rule {
    MIN_LENGTH(1),
    MAX_LENGTH(4),
    MIN_NUMBER(0),
    MAX_NUMBER(9),
    THRESHOLD(4);

    private final int value;

    Rule(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}