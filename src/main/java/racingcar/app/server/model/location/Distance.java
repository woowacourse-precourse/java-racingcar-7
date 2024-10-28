package racingcar.app.server.model.location;

import static java.util.Objects.requireNonNull;
import static racingcar.app.server.error.ErrorMessage.DISTANCE_SHOULD_NOT_BE_MINUS;
import static racingcar.app.server.error.ErrorMessage.SHOULD_NOT_BE_NULL;

import java.util.Objects;
import racingcar.app.server.exception.ShouldNotBeMinusException;

public class Distance {

    public static final Distance ZERO = Distance.from(0);
    public static final Distance ONE = Distance.from(1);

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
        validateIsMinus(source);
        return new Distance(this.value + source.value);
    }

    public Position toPosition() {
        return Position.fromDistance(this.value);
    }

    public boolean isLowerThanZero() {
        return this.value < ZERO.value;
    }

    private void validateIsMinus(final Distance source) {
        if (source.isLowerThanZero()) {
            throw new ShouldNotBeMinusException(DISTANCE_SHOULD_NOT_BE_MINUS);
        }
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
