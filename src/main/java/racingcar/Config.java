package racingcar;

public enum Config {
    NUMBER_OF_CAR_LIMIT(10),
    RANDOM_NUMBER_BEGIN(0),
    RANDOM_NUMBER_END(9),
    MOVE_MINIMUM_VALUE(4)
    ;

    private final Object value;


    Config(int value) {
        this.value = value;
    }

    public String getString() {
        return value.toString();
    }

    public int getValue() {
        if (value instanceof Integer) {
            return (int) value;
        } else {
            throw new IllegalStateException("This config is not an integer");
        }
    }
}
