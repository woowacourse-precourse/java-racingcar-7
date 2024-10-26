package racingcar.model;

public enum CarTestConstants {
    FORWARDING_TEST(1),
    FORWARD_RANDOM_NUM(5),
    STOPPING_TEST(0),
    STOP_RANDOM_NUM(3);

    private final int value;

    CarTestConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
