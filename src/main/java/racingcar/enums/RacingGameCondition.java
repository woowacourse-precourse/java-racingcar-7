package racingcar.enums;

public enum RacingGameCondition {
    MOVE_THRESHOLD(4);

    private final int value;

    RacingGameCondition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
