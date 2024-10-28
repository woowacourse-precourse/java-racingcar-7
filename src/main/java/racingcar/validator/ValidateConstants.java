package racingcar.validator;

public enum ValidateConstants {

    MAX_NAME_LENGTH(5),
    MIN_RACE_COUNT(1);

    private final int value;

    ValidateConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
