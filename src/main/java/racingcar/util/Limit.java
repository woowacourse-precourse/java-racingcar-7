package racingcar.util;

public enum Limit {
    DEFAULT(0),
    MIN_POSITION(-1),
    MIN_NUMBER(0),
    MAX_NUMBER(9),
    ;

    int value;

    Limit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
