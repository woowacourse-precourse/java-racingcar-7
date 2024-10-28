package racingcar.service.constant;

public enum RacingRules {

    CAR_NAME_LENGTH_LIMIT(5L),

    ENOUGH_TORQUE_OUTPUT(4L),
    TORQUE_RANGE_MIN(0L),
    TORQUE_RANGE_MAX(9L),

    BASIC_ENGINE_PERFORMANCE_REGULATION(1L),
    BASIC_OIL_CONSUMPTION_REGULATION(1L),

    MIN_LAP_COUNT(1L);

    private final Long status;

    RacingRules(Long status) {
        this.status = status;
    }

    public Long status() {
        return status;
    }

    public Integer intStatus() {
        return status.intValue();
    }
}
