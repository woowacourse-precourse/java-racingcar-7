package racingcar.model.number;

public class Number {
    private static final int FORWARD_THRESHOLD = 4;
    private final int number;

    protected Number(final int number) {
        this.number = number;
    }

    public boolean isGreaterThanForwardThreshold() {
        return number >= FORWARD_THRESHOLD;
    }
}
