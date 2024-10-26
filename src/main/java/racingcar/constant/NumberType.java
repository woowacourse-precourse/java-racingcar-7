package racingcar.constant;

public enum NumberType {
    MIN_CAR_SIZE(2),
    MIN_COUNT(1),
    MAX_NAME_LENGTH(5),
    MIN_NAME_LENGTH(1),
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    START_LOCATION(0),
    NUMBER_THRESHOLD(4);

    private final int number;

    NumberType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
