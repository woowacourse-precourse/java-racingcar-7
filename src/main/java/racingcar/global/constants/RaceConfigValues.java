package racingcar.global.constants;

public enum RaceConfigValues {

    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9);
    private final Integer value;

    RaceConfigValues(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}
