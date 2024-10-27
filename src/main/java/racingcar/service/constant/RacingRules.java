package racingcar.service.constant;

public enum RacingRules {

    CAR_NAME_LENGTH_LIMIT(5L);

    private final Long status;

    RacingRules(Long status) {
        this.status = status;
    }

    public Long status() {
        return status;
    }
}
