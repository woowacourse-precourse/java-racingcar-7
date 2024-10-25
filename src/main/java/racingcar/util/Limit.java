package racingcar.util;

public enum Limit {
    DEFAULT(0),
    ;

    int value;

    Limit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
