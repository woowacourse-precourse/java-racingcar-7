package racingcar.model;

public enum ModelTestConstants {
    FORWARDING_TEST(1),
    FORWARD_RANDOM_NUM(5),
    STOPPING_TEST(0),
    STOP_RANDOM_NUM(3),
    WINNER_POSITION_NUM(5),
    FAILURE_POSITION_NUM(3);

    private final int value;

    ModelTestConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
