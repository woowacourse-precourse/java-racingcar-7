package racingcar.controller.constant;

public enum RaceRule {

    LAST_LAP(0L);

    private final Long status;

    RaceRule(Long id) {
        this.status = id;
    }

    public Long get() {
        return status;
    }
}
