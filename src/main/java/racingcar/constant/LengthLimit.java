package racingcar.constant;

public enum LengthLimit {

    LENGTH_LIMIT(5);

    private final int value;

    LengthLimit(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
