package racingcar.util;

public enum Limit {
    DEFAULT(0),
    MIN_POSITION(-1),
    MIN_NUMBER(0),
    MIN_PLAY(1),
    MAX_NUMBER(9),
    MAX_PLAY(9),
    CAR_NAME_LENGTH(5),
    ALLOW_MOVE(4),
    SINGLE_DISTANCE(1),
    ;

    int value;

    Limit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
