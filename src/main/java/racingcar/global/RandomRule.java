package racingcar.global;

public enum RandomRule {

    RANDOM_START(0),
    RANDOM_END(9);

    private final int value;

    RandomRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
