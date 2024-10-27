package racingcar.global.constants;

public enum RaceConfigValues {
    MAX_CAR_NAME_LENGTH_NUMBER(5),
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
