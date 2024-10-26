package racingcar.global;

public enum CarNameRule {

    MAX_LENGTH(5);

    private final int value;

    CarNameRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
