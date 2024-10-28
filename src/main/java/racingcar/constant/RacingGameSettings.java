package racingcar.constant;

public enum RacingGameSettings {
    PICK_NUMBER_START(0),
    PICK_NUMBER_END(9),
    MOVABLE_NUMBER_THRESHOLD(4)
    ;

    private final int value;

    RacingGameSettings(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
