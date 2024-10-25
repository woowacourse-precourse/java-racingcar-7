package racingcar.model.position;

import static java.util.Objects.isNull;
import static racingcar.common.message.ErrorMessage.DISTANCE_SHOULD_NOT_BE_MINUS;

import java.util.Objects;
import java.util.stream.LongStream;
import racingcar.common.exception.ShouldNotBeNullException;
import racingcar.model.race.exception.ShouldNotBeMinusException;

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
        validateIsNull(source);

        long subtracted = this.value + source.value;
        validateIsMinus(subtracted);

        return new Distance(subtracted);
    }

    private void validateIsNull(Distance source) {
        if (isNull(source)) {
            throw new ShouldNotBeNullException();
        }
    }

    private void validateIsMinus(long source) {
        if (source < 0) {
            throw new ShouldNotBeMinusException(DISTANCE_SHOULD_NOT_BE_MINUS);
        }
    }

    public LongStream initiateLongStream() {
        return LongStream.range(ZERO.value, this.value);
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
