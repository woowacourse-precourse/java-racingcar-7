package racingcar.global;

public enum ProgressRule {

    FORWARD_CONDITION(4);

    private final int value;

    ProgressRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
