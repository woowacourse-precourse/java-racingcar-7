package racingcar.car.constant;

public enum RacingLimit {
    MIN_COUNT(1),
    MAX_COUNT(9999),

    MAX_CAR_NAME_LENGTH(5),
    MAX_CAR(99),

    RANDOM_MIN(1),
    MIN_MOVE_NUMBER(4),
    RANDOM_MAX(9),

    MOVING_FORWARD(1),

    START_POINT(0);
    private final Integer number;

    RacingLimit(Integer limit) {
        this.number = limit;
    }

    public Integer getNumber() {
        return number;
    }
}
