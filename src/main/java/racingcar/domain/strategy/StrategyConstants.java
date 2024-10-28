package racingcar.domain.strategy;

public enum StrategyConstants {

    MOVE_THRESHOLD(4),
    START_RANGE(0),
    END_RANGE(9);

    private final int value;

    StrategyConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
