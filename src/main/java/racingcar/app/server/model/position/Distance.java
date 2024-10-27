package racingcar.app.server.model.position;

import static java.util.Objects.requireNonNull;
import static racingcar.app.server.error.ErrorMessage.SHOULD_NOT_BE_NULL;

import java.util.Objects;
import java.util.stream.LongStream;

public class Distance {

    public static final Distance ZERO = new Distance(0);
    public static final Distance ONE = new Distance(1);

    private final long value;

    private Distance(final long source) {
        this.value = source;
    }

    public static Distance from(final long source) {
        return new Distance(source);
    }

    public boolean isBiggerThanZero() {
        return this.value > ZERO.value;
    }

    public Distance add(final Distance source) {
        requireNonNull(source, SHOULD_NOT_BE_NULL);
        return new Distance(this.value + source.value);
    }

    public LongStream initiateLongStream() {
        return LongStream.range(ZERO.value, this.value);
    }

    public boolean isLowerThanZero() {
        return this.value < ZERO.value;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Distance oDistance = (Distance) obj;
        return this.value == oDistance.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
