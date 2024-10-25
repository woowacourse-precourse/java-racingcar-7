package racingcar.model.race;

import java.util.stream.IntStream;

public class Distance {

    public static final Distance ZERO = new Distance(0);
    public static final Distance ONE = new Distance(1);

    private final int value;

    private Distance(final int source) {
        this.value = source;
    }

    public boolean isBiggerThanZero() {
        return this.value > ZERO.value;
    }

    public boolean isZero() {
        return this.value == ZERO.value;
    }

    public IntStream initiateIntStream() {
        return IntStream.range(ZERO.value, this.value);
    }
}
