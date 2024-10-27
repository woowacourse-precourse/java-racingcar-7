package racingcar.constant;

public enum Condition {
    FORWARD_CONDITION(4), SINGLE_WINNERS(1), FIRST_CARS_POSITION(0), SIZE_DECREMENT_FOR_LAST_INDEX(1), SINGLE_ELEMENT(1), MIN_RACE_COUNT(1);

    private int value;

    Condition(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
