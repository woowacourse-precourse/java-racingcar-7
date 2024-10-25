package racingcar.util;

public enum RegisterCarNumberConstant {

    REGISTER_CARS_INPUT_MAX_LENGTH(1_000),
    CAR_NAME_MAX_LENGTH(5),
    PRIME_CAR_DISTANCE(0);

    private final int value;

    RegisterCarNumberConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
