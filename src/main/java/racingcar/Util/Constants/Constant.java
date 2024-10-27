package racingcar.Util.Constants;

public enum Constant {
    DISTANCE_OF_WINNER(0);

    private final Integer value;

    Constant(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
