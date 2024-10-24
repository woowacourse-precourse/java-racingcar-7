package constant;

public enum Race {
    MIN_RANDOM_VALUE(0),
    MAX_RANDOM_VALUE(9),
    MOVE_THRESHOLD(4),
    MOVE_STEP(1),

    MIN_CAR_COUNT(2),

    MAX_CAR_NAME_LENGTH(5);


    private final int value;

    Race(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
